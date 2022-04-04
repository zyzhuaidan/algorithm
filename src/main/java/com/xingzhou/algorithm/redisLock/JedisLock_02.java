package com.xingzhou.algorithm.redisLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;
import java.util.UUID;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName JedisLock_02.java
 * @Description TODO
 * @createTime 2022年04月04日 21:21:00
 */
public class JedisLock_02 {
    private Jedis jedis;
    /**
     * 锁key
     */
    private String key;
    /**
     * 锁超时时间,毫秒为单位
     */
    private int expire;
    /**
     * 获取锁等待时间,毫秒为单位
     */
    private int timeout;
    /**
     * 是否占有锁
     */
    private volatile boolean locked = false;
    /**
     * 唯一标识
     */
    private UUID uuid;
    /**
     * 线程等待时间
     */
    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;

    /**
     * 删除key的lua脚本
     */
    private static final String LUA_DEL_SCRIPT = "if com.xingzhou.algorithm.redis.call('GET',KEYS[1]) == ARGV[1] then return com.xingzhou.algorithm.redis.call('DEL',KEYS[1]) else return 0 end";


    public JedisLock_02(Jedis videoJedis, String key, int timeout, int expire) {
        this.jedis = videoJedis;
        this.key = key;
        this.timeout = timeout;
        this.expire = expire;
        this.uuid = UUID.randomUUID();
    }

    /**
     * set值
     * 说明：这个命令仅在不存在key的时候才能被执行成功（NX选项），并且这个key有一个自动失效时间（PX属性）
     * 这个key的值是一个唯一值，这个值在所有的客户端必须是唯一的，所有同一key的获取者（竞争者）这个值都不能一样。
     *
     * @param value
     * @return
     */
    public String setNX(final String value) {
        SetParams params = new SetParams();
        params.ex(this.expire);
        return jedis.set(key, value, params);
    }

    /**
     * 获取锁
     *
     * @return
     */
    public synchronized boolean lock() throws InterruptedException {
        long timeout = this.timeout;
        while (timeout > 0) {
            //获取锁,返回OK则代表获取锁成功
            if ("OK".equals(this.setNX(this.getLockValue(Thread.currentThread().getId())))) {
                this.locked = true;
                return true;
            }
            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
        }
        return false;
    }

    /**
     * 释放锁
     * 说明：通过key和唯一value值删除
     *
     * @return
     */
    public synchronized void release() {
        if (this.locked) {
            long result = (long) this.jedis.eval(LUA_DEL_SCRIPT, 1, this.key, this.getLockValue(Thread.currentThread().getId()));
            if (result > 0) {
                this.locked = false;
            }
        }

    }

    /**
     * 判断当前线程是否还继续拥有锁
     * 说明：该方法主要用来判断操作时间已经超过key的过期时间,可以用来做业务过滚
     *
     * @return
     */
    public boolean checkTimeOut() {
        if (this.locked) {
            String value = this.jedis.get(this.key);
            if (this.getLockValue(Thread.currentThread().getId()).equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 锁的value值（唯一值）
     * 说明：value的值必须是唯一主要是为了更安全的释放锁，
     * 释放锁的时候使用脚本告诉Redis:只有key存在并且存储的值和我指定的值一样才能告诉我删除成功
     *
     * @param threadId
     * @return
     */
    public String getLockValue(Long threadId) {
        return this.uuid.toString() + "_" + threadId;
    }

}
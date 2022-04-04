package redisLock;

import redis.clients.jedis.Jedis;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName JedisLock.java
 * @Description TODO
 * @createTime 2022年04月04日 20:58:00
 */
public class JedisLock {
    Jedis jedis;
    /**
     * redis key
     */
    String lockKey;
    /**
     * 过期时间
     */
    int expireMsecs;
    /**
     * 超时时间
     */
    int timeoutMsecs;
    /**
     * redis锁状态
     */
    boolean locked;

    public JedisLock(Jedis jedis, String lockKey) {
        this.expireMsecs = 60000;
        this.timeoutMsecs = 10000;
        this.locked = false;
        this.jedis = jedis;
        this.lockKey = lockKey;
    }

    public JedisLock(Jedis jedis, String lockKey, int timeoutMsecs) {
        this(jedis, lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }

    public JedisLock(Jedis jedis, String lockKey, int timeoutMsecs, int expireMsecs) {
        this(jedis, lockKey, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }

    public JedisLock(String lockKey) {
        this((Jedis) null, lockKey);
    }

    public JedisLock(String lockKey, int timeoutMsecs) {
        this((Jedis) null, lockKey, timeoutMsecs);
    }

    public JedisLock(String lockKey, int timeoutMsecs, int expireMsecs) {
        this((Jedis) null, lockKey, timeoutMsecs, expireMsecs);
    }

    public String getLockKey() {
        return this.lockKey;
    }

    public synchronized boolean acquire() throws InterruptedException {
        return this.acquire(this.jedis);
    }

    /**
     * 获得 lock.
     * 实现思路: 主要是使用了redis 的setnx命令,缓存了锁.
     * reids缓存的key是锁的key,所有的共享, value是锁的到期时间(注意:这里把过期时间放在value了,没有时间上设置其超时时间)
     * 执行过程:
     * 1.通过setnx尝试设置某个key的值,成功(当前没有这个锁)则返回,成功获得锁
     * 2.锁已经存在则获取锁的到期时间,和当前时间比较,超时的话,则设置新的值
     */

    public synchronized boolean acquire(Jedis jedis) throws InterruptedException {
        int timeout = this.timeoutMsecs;

        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + (long) this.expireMsecs + 1L;
            //锁到期时间
            String expiresStr = String.valueOf(expires);
            if (jedis.setnx(this.lockKey, expiresStr) == 1L) {
                this.locked = true;
                return true;
            }
            /**
             * 判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
             * 获取上一个锁到期时间，并设置现在的锁到期时间，
             * 只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
             */
            String currentValueStr = jedis.get(this.lockKey);
            if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                /**
                 * 判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
                 *  lock is expired
                 */
                String oldValueStr = jedis.getSet(this.lockKey, expiresStr);
                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    /**
                     *   防止误删（覆盖，因为key是相同的）了他人的锁——这里达不到效果，这里值会被覆盖，但是因为什么相差了很少的时间，所以可以接受
                     *   [分布式的情况下]:如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                     *  lock acquired
                     */

                    this.locked = true;
                    return true;
                }
            }
            /**
             延迟100 毫秒,  这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
             只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
             使用随机的等待时间可以一定程度上保证公平性
             */
            timeout -= 100;
            Thread.sleep(100L);
        }

        return false;
    }

    public synchronized void release() {
        this.release(this.jedis);
    }

    public synchronized void release(Jedis jedis) {
        if (this.locked) {
            jedis.del(new String[]{this.lockKey});
            this.locked = false;
        }

    }
}



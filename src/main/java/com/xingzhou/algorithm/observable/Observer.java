package com.xingzhou.algorithm.observable;

/**
 * @title
 * @description
 * @author xingzhou
 * @updateTime 2022/4/5 7:59 上午
 * @throws
 */
interface Observer {
    /**
     *  当主题状态改变时,会将一个String类型字符传入该方法的参数,
     *  每个观察者都需要实现该方法
     */
    public void update(String info);
}

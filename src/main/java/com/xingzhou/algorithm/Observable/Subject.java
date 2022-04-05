package com.xingzhou.algorithm.Observable;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Subject.java
 * @Description 主题接口
 * @createTime 2022年04月05日 07:42:00
 */
interface Subject {
    /**
     * 添加观察者
     * @param obj
     */
    void addObserver(Observer obj);

    /**
     * 移除观察者
     * @param obj
     */
    void deleteObserver(Observer obj);

    /**
     * 通知观察者
     */
    void notifyObserver();
}

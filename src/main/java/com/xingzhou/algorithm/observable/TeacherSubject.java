package com.xingzhou.algorithm.observable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName TeacherSubject.java
 * @Description TODO
 * @createTime 2022年04月05日 07:46:00
 */
public class TeacherSubject implements Subject {
    private List<Observer> observers=new ArrayList<Observer>();
    //记录状态的字符串
    private String info;

    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            Observer o=(Observer)observers.get(i);
            o.update(info);
        }
    }
    //布置作业的方法,在方法最后,需要调用notifyObserver()方法,通知所有观察者更新状态
    public void setHomework(String info){
        this.info=info;
        System.out.println("今天的作业是"+info);
        this.notifyObserver();
    }

}
package com.xingzhou.algorithm.observable;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName StudentObserver.java
 * @Description TODO
 * @createTime 2022年04月05日 07:49:00
 */
public class StudentObserver implements Observer {

    /**
     *  保存一个Subject的引用,以后如果可以想取消订阅,有了这个引用会比较方便
     */
    private TeacherSubject t;
    /**
     * 学生的姓名,用来标识不同的学生对象
     */
    private String name;

    /**
     *  构造器用来注册观察者
     */
    public StudentObserver(String name, TeacherSubject t) {
        this.name = name;
        this.t = t;
        //每新建一个学生对象,默认添加到观察者的行列
        t.addObserver(this);
    }


    @Override
    public void update(String info) {
        System.out.println(name + "得到作业:" + info);

    }
}
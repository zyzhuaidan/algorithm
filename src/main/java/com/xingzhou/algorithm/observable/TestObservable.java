package com.xingzhou.algorithm.observable;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName TestObservable.java
 * @Description TODO
 * @createTime 2022年04月05日 07:52:00
 */
public class TestObservable {

    public static void main(String[] args) {

        TeacherSubject teacher=new TeacherSubject();
        StudentObserver zhangSan=new StudentObserver("张三", teacher);
        StudentObserver LiSi=new StudentObserver("李四", teacher);
        StudentObserver WangWu=new StudentObserver("王五", teacher);

        teacher.setHomework("第二页第六题");
        teacher.setHomework("第三页第七题");
        teacher.setHomework("第五页第八题");
    }
}

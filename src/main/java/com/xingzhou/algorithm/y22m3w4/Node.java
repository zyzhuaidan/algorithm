package com.xingzhou.algorithm.y22m3w4;

import java.util.ArrayList;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Node.java
 * @Description TODO
 * @createTime 2022年03月21日 10:38:00
 */
public class Node {
    int out;
    int in;
    int value;
    ArrayList<Node>  nexts;
    ArrayList<Edge> edges;
    public Node(int value){
        this.out = 0;
        this.in = 0;
        this.value = value;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

}

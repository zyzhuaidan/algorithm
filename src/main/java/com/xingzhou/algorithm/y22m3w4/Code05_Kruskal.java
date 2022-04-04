package com.xingzhou.algorithm.y22m3w4;

import java.util.HashMap;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code05_Kruskal.java
 * @Description TODO
 * @createTime 2022年03月23日 22:58:00
 */
public class Code05_Kruskal {
    //并查集（Union-Find）是解决动态连通性问题的一类非常高效的数据结构
    public static class UnionFind{
        //父集合
        private HashMap<Node, Node> fatherMap;
        //key 某一个集合， value key所在的集合的节点数目
        private HashMap<Node, Integer> sizeMap;

        public UnionFind(){
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }
        public void makeSet(){

        }

    }

}

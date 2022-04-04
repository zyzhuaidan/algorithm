package com.xingzhou.algorithm.y22m3w4;

import java.util.*;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code04_TopologySort.java
 * @Description TODO
 * @createTime 2022年03月23日 22:01:00
 */
public class Code04_TopologySort {
    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> imMap = new HashMap<>();
        //入度为零的队列， 优先处理
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            imMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        ArrayList<Node> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next:cur.nexts){
                imMap.put(next, imMap.get(next) - 1);
                if(imMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}

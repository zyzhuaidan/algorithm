package y22m3w4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code04_TopologicalOrderBFS.java
 * @Description 图的BFS拓扑排序
 * @createTime 2022年03月23日 22:12:00
 */
public class Code04_TopologicalOrderBFS {
    public static class DirectedGraphNode{
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;
        public DirectedGraphNode(int x){
            this.label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
        HashMap<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        for(DirectedGraphNode cur : graph){
            indegreeMap.put(cur, 0);
        }
        for(DirectedGraphNode cur : graph){
            for(DirectedGraphNode next: cur.neighbors){
                indegreeMap.put(next, indegreeMap.get(next) + 1);
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        //入度为0加如队列
        for(DirectedGraphNode cur : indegreeMap.keySet()){
            if(indegreeMap.get(cur) == 0){
                queue.add(cur);
            }
        }
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while(!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            res.add(cur);
            for(DirectedGraphNode next : cur.neighbors){
                indegreeMap.put(next, indegreeMap.get(next) - 1);
                //入度为0 加入队列
                if(indegreeMap.get(next) == 0){
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}

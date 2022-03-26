package y22m3w4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code04_TopologicalOrderDFS01.java
 * @Description TODO
 * @createTime 2022年03月23日 22:28:00
 */
public class Code04_TopologicalOrderDFS01 {
    public static class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            this.label = x;
        }
    }

    public static class Record {
        public DirectedGraphNode node;
        public int deep;

        public Record(DirectedGraphNode node, int deep) {
            this.node = node;
            this.deep = deep;
        }
    }

    public static class MyComparator implements Comparator<Record> {
        @Override
        public int compare(Record o1, Record o2) {
            return o2.deep - o1.deep;
        }
    }


    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Record> order = new HashMap<>();
        for (DirectedGraphNode cur : graph) {
            f(cur, order);
        }
        //存储所有的node节点
        ArrayList<Record> records = new ArrayList<>();
        for (Record r : order.values()) {
            records.add(r);
        }
//        排序？
        records.sort(new MyComparator());
        records.sort(new MyComparator());
        ArrayList<DirectedGraphNode> directedGraphNodes = new ArrayList<>();
        for (Record r : records) {
            directedGraphNodes.add(r.node);
        }
        return directedGraphNodes;
    }

    //计算每个node的深度
    public static Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode, Record> order) {
        if (order.containsKey(cur)) {
            return order.get(cur);
        }
        int follow = 0;
        for (DirectedGraphNode next : cur.neighbors) {
            follow = Math.max(follow, f(next, order).deep);
        }
        Record ans = new Record(cur, follow + 1);
        order.put(cur, ans);
        return ans;
    }
}

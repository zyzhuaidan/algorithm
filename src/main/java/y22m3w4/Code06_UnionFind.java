package y22m3w4;

import java.util.HashMap;
import java.util.List;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code06_UnionFind.java
 * @Description 并查集
 * @createTime 2022年03月26日 16:11:00
 */
public class Code06_UnionFind {
    public static class Node<V>{
        V value;
        public Node(V v){
            value = v;
        }
    }
    public static class UnionFind<V>{
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;
        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for(V cur:values){
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node,node);
                sizeMap.put(node, 1);
            }


        }

    }
}

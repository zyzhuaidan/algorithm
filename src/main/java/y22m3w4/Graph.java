package y22m3w4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Graph.java
 * @Description TODO
 * @createTime 2022年03月21日 10:50:00
 */
public class Graph {
    Map<Integer, Node> nodes;
    Set<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

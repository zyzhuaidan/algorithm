package y22m3w4;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Edge.java
 * @Description TODO
 * @createTime 2022年03月21日 10:31:00
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

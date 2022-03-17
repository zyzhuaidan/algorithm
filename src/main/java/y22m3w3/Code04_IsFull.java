package y22m3w3;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code04_IsFull.java
 * @Description TODO
 * @createTime 2022年03月17日 15:20:00
 */
public class Code04_IsFull {
    class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    class Info{
        int height;
        boolean isFull;
        public Info(int height, boolean isFull){
            this.height = height;
            this.isFull = isFull;
        }
    }
    public Info process(Node x){
        if(x == null){
            return new Info(0, true);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        return new Info(height, isFull);
    }
}

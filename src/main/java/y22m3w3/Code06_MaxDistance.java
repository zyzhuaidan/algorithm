package y22m3w3;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code06_MaxDistance.java
 * @Description TODO
 * @createTime 2022年03月18日 16:21:00
 */
public class Code06_MaxDistance {
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
        int maxDistance;
        public Info(int height, int maxDistance){
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public Info process(Node x){
        if(x == null){
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int h1 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(h1, leftInfo.maxDistance), rightInfo.maxDistance);
        return new Info(height, maxDistance);
    }
}

package y22m3w3;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code03_IsBalanced.java
 * @Description TODO
 * @createTime 2022年03月17日 14:56:00
 */
public class Code03_IsBalanced {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }
    }

    class Info {
        int height;
        boolean isBalanced;

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public Info process(Node x) {
        if (x == null) {
            return new Info(0, true);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalanced) {
            isBalanced = false;
        }
        if(!rightInfo.isBalanced){
            isBalanced =false;
        }
        if(Math.abs(leftInfo.height -rightInfo.height) > 1){
            isBalanced = false;
        }
        return new Info(height, isBalanced);
    }
}

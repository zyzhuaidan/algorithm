package com.xingzhou.algorithm.y22m3w4;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code01_lowestAncestor.java
 * @Description TODO
 * @createTime 2022年03月20日 14:27:00
 */
public class Code01_lowestAncestor {
    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    class Info {
        boolean isFindA;
        boolean isFindB;
        Node ans;

        public Info(boolean isFindA, boolean isFindB, Node ans) {
            this.isFindA = isFindA;
            this.isFindB = isFindB;
            this.ans = ans;
        }
    }

    public Info process(Node x, Node a, Node b) {
        if (x == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);
        boolean isFindA = (x == a) || leftInfo.isFindA || rightInfo.isFindA;
        boolean isFindB = (x == b) || leftInfo.isFindB || rightInfo.isFindB;
        Node ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (isFindA && isFindB) {
                ans = x;
            }
        }
        return new Info(isFindA, isFindB, ans);
    }
}

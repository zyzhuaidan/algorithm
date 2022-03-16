package y22m3w3;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName Code01_IsCBT.java
 * @Description TODO
 * @createTime 2022年03月16日 11:33:00
 */
public class Code01_IsCBT {
    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
        }
    }

    class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;
        public Info(boolean isFull, boolean isCBT, int height){
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
    Info process(Node x){
        if(x == null){
            return new Info(true, true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && rightInfo.height == leftInfo.height;
        boolean isCBT = false;
        if(isFull){
            isCBT = true;
        }else {
            if(leftInfo.isCBT && rightInfo.isCBT){
                if(leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1){
                    isCBT = true;
                }
                if(leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1){
                    isCBT = true;
                }
                if(leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height){
                    isCBT = true;
                }
            }
        }
        return new Info(isFull,isCBT, height);
    }

}

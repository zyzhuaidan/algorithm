package week2;

/**
 * @author xingzhou
 */
public class DeleteGivenValue {
    public static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }

    /**
     * 删除链表中指定的值
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue(Node head, int num){
        /**
         * 跳过头部的指定值，跳过后面多次出现的指定值
         */
        while(head != null){
            if(head.val != num){
                break;
            }
            head = head.next;
        }
        //1. head == null
        //2. head != null
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if(cur.val == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

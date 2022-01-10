package week2;

/**
 * @author xingzhou
 */
public class ReverseList {
    static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    static class DoubleNode{
        public int val;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int val){
            this.val = val;
        }
    }
    /**
     * 单向链表翻转
     */
    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双向链表翻转
     */
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}

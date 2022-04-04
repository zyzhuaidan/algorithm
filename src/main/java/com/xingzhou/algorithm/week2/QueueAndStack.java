package com.xingzhou.algorithm.week2;

/**
 * @author xingzhou
 */
public class QueueAndStack {
    /**
     * 利用数组实现队列
     */
    public static class MyQueue {
        private int[] arr;
        private int pushI;
        private int pollI;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pollI = 0;
            pushI = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int val) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushI] = val;
            pushI = nextIndex(pushI);
        }
        public int pop(){
            if(size == 0){
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans = arr[pollI];
            pushI = nextIndex(pollI);
            return ans;
        }

        private int nextIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }
}

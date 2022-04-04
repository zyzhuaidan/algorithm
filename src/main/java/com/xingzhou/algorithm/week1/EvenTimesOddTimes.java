package com.xingzhou.algorithm.week1;

public class EvenTimesOddTimes {
    /**
     * 一个数组中只有一种数出现了奇数次，
     * 其他数都出现了偶数次，怎么找到病打印这种数
     */
    public static void printOddTimesNum1(int[] arr) {
        /**
         * 异或的本质，非进位加法
         * 相异为1 相同为0
         * 所以只需要遍历一遍就可以得到结果
         */
        int eor = 0;
        for (int a : arr) {
            eor ^= a;
        }
        System.out.println(eor);
    }

    /**
     * 二进制中1的个数
     */
    public static void printHammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        System.out.println(res);
    }

    /**
     * 一个数组中有两种数出现奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     */
    public static void printOddTimesNum2(int[] arr) {
        /**
         * 分组异或
         */
        int eor = 0;
        for (int a : arr) {
            eor ^= a;
        }
        /**
         *  a 和 b 是两种数
         *  eor ！= 0
         *  eor最右侧的1 提取出来，然后分组
         */
        int ringtOne = eor & (-eor); //提取出最右侧的1
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & ringtOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    /**
     * 一个数组中有一个数出现K次，其他数都出现了M次， M > 1, K < m,求出现了K次
     * 的数，要求 空间 O(1), 时间 O(N)
     *
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % m == k) {
                ans |= (1 << i);
            } else {
                return -1;
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == ans) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 3, 4};
        int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 5, 66, 66, 7, 7};
        printOddTimesNum1(arr1);
        printOddTimesNum2(arr2);
        System.out.println(onlyKTimes(arr1, 1, 2));
    }
}


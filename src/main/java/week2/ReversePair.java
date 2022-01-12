package week2;

/**
 * @author xingzhou
 */
public class ReversePair {
    public static int reversePairNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int index = help.length - 1;
        int p1 = mid;
        int p2 = right;
        int res = 0;
        while (p1 >= left && p2 > mid) {
            res += arr[p1] > arr[p2] ? (p2 - mid) : 0;
            help[index--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= left) {
            help[index--] = arr[p1--];
        }
        while (p2 > mid) {
            help[index--] = arr[p2--];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 56, 23, 1};
        System.out.println(reversePairNum(arr));
    }
}

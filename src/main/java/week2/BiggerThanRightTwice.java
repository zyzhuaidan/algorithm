package week2;

/**
 * @author xingzhou
 */
public class BiggerThanRightTwice {
    public static int biggerTwice(int[] arr) {
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
        int res = 0;
        //目前囊括进来的数 （mid + 1, windowR）
        int windowR = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (windowR <= right && arr[i] > (arr[windowR] * 2)) {
                windowR++;
            }
            res += windowR - mid - 1;
        }
        int[] help = new int[right - left + 1];
        int index = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= right) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,34,1,123};
        System.out.println(biggerTwice(arr));
    }
}

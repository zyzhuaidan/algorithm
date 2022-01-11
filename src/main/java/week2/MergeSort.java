package week2;

public class MergeSort {
    /**
     * 递归方法实现
     */
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
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
        for (index = 0; index < help.length; index++) {
            arr[left + index] = help[index];
        }
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //步长
        int mergeSize = 1;
        //log N
        while(mergeSize < N){
            // 当前左组的，第一个位置
            int left = 0;
            while(left < N){
                if(mergeSize >= N - left){
                    break;
                }
                int mid = left + mergeSize - 1;
                int right = mid + Math.min(mergeSize, N - mid - 1);
                merge(arr, left, mid, right);
                left = right + 1;
            }
            if(mergeSize > N / 2){
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 34, 56, 5, 3, 56, 3, 23, 54, -678, 435};
        mergeSort2(arr);
        for (int num : arr) {
            System.out.print(num + "--->");
        }
    }
}

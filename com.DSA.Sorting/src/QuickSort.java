public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        int[] ans = QuickSorting(arr, 0, arr.length - 1);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] QuickSorting(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = partition(arr, l, h);
            QuickSorting(arr, l, pivot - 1);
            QuickSorting(arr, pivot + 1, h);
        }
        return arr;
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = l;
        int i = l, j = h;
        while (i < j) {
            while (arr[i] <= arr[pivot] && i < h) {
                i++;
            }
            while (arr[j] > arr[pivot] && j > l) {
                j--;
            }
            if (i < j) {
                //swap
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }
        //swap
        if (j != l) {
            arr[j] = arr[j] + arr[l];
            arr[l] = arr[j] - arr[l];
            arr[j] = arr[j] - arr[l];
        }
        return j;
    }
}

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 8, 3, 6, 1};
        System.out.println(Arrays.toString(quickSort(arr)));
    }

    private static int[] quickSort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int res = quickSort(arr, i, j);
        quickSort(arr, i, res - 1);
        quickSort(arr, res + 1, j);
        return arr;
    }

    private static int quickSort(int[] arr, int i, int j) {
        int l = i, h = j, pivot = i;
        while (l < h) {
            while (arr[l] <= arr[pivot]) {
                l++;
            }
            while (arr[h] >= arr[pivot]) {
                h--;
            }
            if (l < h) {
                arr[l] = arr[l] + arr[h];
                arr[h] = arr[l] - arr[h];
                arr[l] = arr[l] - arr[h];
            }
        }
        arr[pivot] = arr[pivot] + arr[h];
        arr[h] = arr[pivot] - arr[h];
        arr[pivot] = arr[pivot] - arr[h];

        return h;

    }
}
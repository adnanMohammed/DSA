public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 8, 5, 2, 1};
        for (int i1 : mergeSorting(arr, 0, arr.length - 1)) {
            System.out.print(i1 + " ");
        }
        ;
    }

    public static int[] mergeSorting(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSorting(arr, l, mid);
            mergeSorting(arr, mid + 1, h);
            merge(arr, l, mid, h);

        }
        return arr;
    }

    public static int[] merge(int[] arr, int l, int mid, int r) {
        int[] b = new int[r - l + 1];
        int k = 0;
        int rep = l;
        int i = l;
        int j = mid + 1;
        while (i < mid + 1 && j <= r) {
            if (arr[i] < arr[j]) {
                b[k] = arr[i];
                i++;
                k++;
            } else {
                b[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i < mid + 1) {
            b[k] = arr[i];
            k++;
            i++;
        }
        while (j <= r) {
            b[k] = arr[j];
            k++;
            j++;
        }
        for (int m = 0; m < b.length; m++) {
            arr[rep] = b[m];
            rep++;
        }
        return arr;
    }

}

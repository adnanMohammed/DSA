public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 3, 8, 6};
        selectionSorting(arr);
    }

    public static int[] selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                //swap
                arr[i] = arr[i] + arr[min];
                arr[min] = arr[i] - arr[min];
                arr[i] = arr[i] - arr[min];
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        return arr;

    }
}

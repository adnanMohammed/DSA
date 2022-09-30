public class insertionSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 5, 9, 2};
        for (int i : insertionSortingWhile(arr)) {
            System.out.print(i + " ");
        }
    }

    //insertion sort using while
    public static int[] insertionSortingWhile(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    //insertion sort using for
    public static int[] insertionSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {

                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }
}

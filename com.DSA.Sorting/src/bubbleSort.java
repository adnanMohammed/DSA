public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 2, 6, 4};
        for (int i : bubbleSort(arr)) {
            System.out.print(i + " ");
        }
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSwapped = true;
                    //swap
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
            if (!isSwapped) {
                break;
            }

        }
        return arr;
    }

}

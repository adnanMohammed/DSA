public class Main {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        //bubbleSort(arr);
        //insertionSort(arr);
        //selectionSort(arr);
        for (int i : QuickSort(arr, 0, arr.length - 1)) {
            System.out.print(i + " ");
        }
    }


    public static int[] QuickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = partition(arr, l, h);
            QuickSort(arr, l, pivot - 1);
            QuickSort(arr, pivot + 1, h);
        }
        return arr;
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = l;
        int i = l;
        int j = h;
        while (i < j) {
            while (arr[i] <= arr[pivot] && i < h) {
                i++;
            }
            while (arr[j] > arr[pivot] && j > l) {
                j--;
            }
            if (i != j && i < j) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }

        }

        if (l != j) {
            arr[l] = arr[l] + arr[j];
            arr[j] = arr[l] - arr[j];
            arr[l] = arr[l] - arr[j];
        }
        return j;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
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


    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
        return arr;
    }


    //bubble Sort
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - 1; j++) {
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
        for (int i : arr)
            System.out.print(i + " ");

        return arr;
    }

}
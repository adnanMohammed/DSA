import java.awt.desktop.QuitEvent;
import java.util.Arrays;

public class SortingExample {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 9, 12, 14};
        // System.out.println(Arrays.toString(selectionSort(arr)));
        // System.out.println(Arrays.toString( QuickSort(arr, 0, arr.length - 1)));
       // System.out.println(binarySearchRecursion(arr, 20, 0, arr.length - 1));
        System.out.println(linearSearch(arr,7));
    }

    public static boolean binarySearchRecursion(int[] arr, int search,int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;
            if (search == arr[mid])
                return true;
            else if (search < arr[mid])
                binarySearchRecursion(arr, search, s, mid - 1);
            else
                binarySearchRecursion(arr, search, mid + 1, e);
        }
        return false;
    }


    public static boolean linearSearch(int[] arr,int search) {
        for (int i = 0; i < arr.length; i++) {
            if (search == arr[i])
                return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int search, int s, int e) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (search == arr[mid])
                return true;
            else if (search < arr[mid])
                e = mid - 1;
            else
                s = mid + 1;
        }
        return false;
    }

    public static int[] mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
        return arr;
    }

    public static int[] merge(int[] arr, int l, int mid, int h) {
        int i = l;
        int j = mid + 1;
        int i1 = 0;
        int[] arr1 = new int[h - l + 1];
        while (i <= mid && j <= h) {
            if (arr[i] < arr[j]) {
                arr1[i1++] = arr[i];
                i++;
            } else {
                arr1[i1++] = arr[j];
                j++;
            }
        }
        if (i <= mid) {
            for (int k = i; k <= mid; k++) {
                arr1[i1++] = arr[k];
            }
        } else if (j <= h) {
            for (int k1 = j; k1 <= h; k1++) {
                arr1[i1++] = arr[k1];
            }
        }

        for (int k = 0; k < arr1.length; k++) {
            arr[l++] = arr1[k];
        }
        return arr;
    }


    public static int[] QuickSort(int[] arr, int i, int j) {
        if (i < j) {
            int properIndexValue = partitioningLogic(arr, i, j);
            QuickSort(arr, i, properIndexValue - 1);
            QuickSort(arr, properIndexValue + 1, j);
        }
        return arr;
    }

    public static int partitioningLogic(int[] arr, int i, int j) {
        int pivot = arr[i], l = i, h = j;

        while (i < j) {
            while (i < arr.length && arr[i] <= pivot)
                i++;
            while (j > 0 && arr[j] > pivot)
                j--;
            if (i < j) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }
        if (l != j) {
            arr[j] = arr[j] + arr[l];
            arr[l] = arr[j] - arr[l];
            arr[j] = arr[j] - arr[l];
        }
        return j;

    }


    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            //swap(min,i)
            if (min != i) {
                arr[i] = arr[i] + arr[min];
                arr[min] = arr[i] - arr[min];
                arr[i] = arr[i] - arr[min];
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = i + 1;
            int j = i;
            while (j >= 0 && (arr[j] > arr[temp])) {
                arr[j] = arr[j] + arr[temp];
                arr[temp] = arr[j] - arr[temp];
                arr[j] = arr[j] - arr[temp];

                temp = j;
                j = j - 1;
            }
        }
        return arr;
    }

    // Time complexityO(n2)
    // Space Complexity
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    count += 1;
                    //swap
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];

                }
            }
            if (count == 0)
                return arr;
        }
        return arr;
    }
}

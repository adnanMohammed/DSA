public class PivotInanRotatedSortedArray {
    //int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};
    public static int findPivot(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                // Found the pivot
                return mid-1;
            } else if (arr[s] <= arr[mid] && arr[mid] > arr[e]) {
                // Search the e half
                s = mid + 1;
            } else {
                // Search the s half
                e = mid - 1;
            }
        }

        // Pivot not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 11, 1, 2, 3};
        int pivot = findPivot(arr);

        if (pivot != -1) {
            System.out.println("Pivot found at index " + pivot);
        } else {
            System.out.println("Pivot not found");
        }
    }
}






























  /*  public static void main(String[] args) {
        int[] arr = {15, 20, 1, 2, 5, 8, 10, 12};
        System.out.println(pivot(arr));
    }

    public static int pivot(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < arr[e] && arr[mid] < arr[s])
                e = mid - 1;
            else if (arr[mid] > arr[s] && arr[mid] > arr[e])
                s = mid;
            else if (arr[mid] >= arr[s] && arr[mid] < arr[e])
                s = mid + 1;
        }
        return e;
    }*/


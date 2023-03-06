public class infiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,  6, 7, 8, 9, 10, 11, 12};
       System.out.println( infinteSortedArraySearch(arr, 5));

    }

    public static int infinteSortedArraySearch(int[] arr, int target) {
        int s = 0, e = 1;
        while (target > arr[e]) {
            int temp = s;
            s = e + 1;
            e = ((e - temp + 1) * 2) + e;
        }
        return binarySearch(arr, target, s, e);
    }

    public static int binarySearch(int[] arr, int target, int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                e = mid - 1;
            else
                s = mid + 1;

        }
        return -1;
    }


}

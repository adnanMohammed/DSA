public class MaxElementInRotated_Sorted_DuplicateArray {
    public static void main(String[] args) {
        int[] arr={2,3,4,5,1};
        int[] arr1={2,3,4,4,5,5,1,2};
        System.out.println( maxElementInAnRotatedArray(arr));
    }

    private static int maxElementInAnRotatedArray(int[] arr) {
        int s = 0, e = arr.length - 1;
        if (arr.length == 1)
            return 0;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1])
                return mid - 1;
            else if (arr[s] <= arr[mid])
                s = mid + 1;
            else if (arr[mid] <= arr[e])
                e = mid - 1;
        }
        return -1;
    }

}

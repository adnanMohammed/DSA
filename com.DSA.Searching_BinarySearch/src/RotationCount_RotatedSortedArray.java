public class RotationCount_RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(RotationCountInRotatedSortedArray(arr));
    }

    //anticlockwise rotation((arr.length-1)-pivot)
    //clockwise
    private static int RotationCountInRotatedSortedArray(int[] arr) {
        return pivot(arr) + 1;
    }

    private static int pivot(int[] arr) {
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

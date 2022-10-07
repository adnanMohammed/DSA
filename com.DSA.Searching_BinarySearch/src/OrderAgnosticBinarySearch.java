public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {9,4,4,3,2,1,0};
        int l = 0, h = arr.length - 1, find = 0;
        System.out.println(OrderAgnosticBinarySearchImp(arr,l,h,find));
    }

    private static int OrderAgnosticBinarySearchImp(int[] arr, int l, int h, int find) {
        if (arr[l] < arr[h]) {
            while (l <= h) {
                int mid = (l + h) / 2;
                if (find < arr[mid])
                    h = mid - 1;
                else if (find > arr[mid])
                    l = mid + 1;
                else
                    return mid;

            }
        } else {
            while (l <= h) {
                int mid = (l + h) / 2;
                if (find < arr[mid])
                    l = mid + 1;
                else if (find > arr[mid])
                    h = mid - 1;
                else
                    return mid;

            }
        }
        return -1;
    }
}

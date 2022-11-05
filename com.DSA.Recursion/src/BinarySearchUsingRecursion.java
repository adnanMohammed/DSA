public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 9, 10};
        int element = 5;
        System.out.println(BinarySearch(arr, element));
    }

    private static int BinarySearch(int[] arr, int element) {
        int start = 0, end = arr.length - 1;
        return BinarySearchRecursive(arr, element, start, end);
    }

    private static int BinarySearchRecursive(int[] arr, int element, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element)
                return mid;
            else if (element < arr[mid])
                return BinarySearchRecursive(arr, element, start, mid - 1);
            else
                return BinarySearchRecursive(arr, element, mid + 1, end);
        }
        return -1;
    }

    private static int BinarySearchRecursiveKunal(int[] arr, int element, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (arr[mid] == element) {
            return mid;
        }
        if (element < arr[mid]) {
            return BinarySearchRecursive(arr, element, start, mid - 1);
        }
        return BinarySearchRecursive(arr, element, mid + 1, end);

    }

}

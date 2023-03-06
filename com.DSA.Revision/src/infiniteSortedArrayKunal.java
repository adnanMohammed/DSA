public class infiniteSortedArrayKunal {
    public static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1; // target not found
    }

    public static int findPosition(int[] arr, int target) {
        int start = 0, end = 1;
        while (target > arr[end]) {
            start = end;
            end *= 2;
        }
        return binarySearch(arr, start, end, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 20;
        int position = findPosition(arr, target);
        if (position == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at position " + position);
        }
    }
}


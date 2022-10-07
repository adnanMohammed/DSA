public class BinarySearch {
    public static void main(String[] args) {
        int find = 1;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("The index is=" + BinarySearchingRecursive(arr, find, 0, arr.length - 1));
    }

    public static int BinarySearchingRecursive(int[] arr, int find, int l, int h) {
        if (l > h) return -1;
        int mid = (l + h) / 2;
        if (find == arr[mid]) return mid;
        if (find < arr[mid]) return BinarySearchingRecursive(arr, find, l, mid - 1);
        else return BinarySearchingRecursive(arr, find, mid + 1, h);
    }

    public static int BinarySearching(int[] arr, int find, int l, int h) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (find == arr[mid]) {
                return mid;
            }
            if (find < arr[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}

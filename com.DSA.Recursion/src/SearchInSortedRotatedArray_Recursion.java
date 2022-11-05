public class SearchInSortedRotatedArray_Recursion {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        int element = 1;
        System.out.println(BS_Rotated(arr, element, 0, arr.length - 1));
    }

    public static int BS_Rotated(int[] arr, int element, int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == element)
                return mid;
            else if (s <= arr[mid]) {
                if (element >= arr[s] && element <= arr[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            else if (element >= arr[mid] && element <= arr[e]) {
                 s = mid + 1;
            } else
                 e = mid - 1;
        }
        return -1;
    }

    public static int BS_Rotated_Recursion(int[] arr, int element, int s, int e) {
        if (s > e)
            return -1;

        int mid = (s + e) / 2;

        if (arr[mid] == element)
            return mid;

        if (s <= arr[mid]) {
            if (element >= arr[s] && element <= arr[mid]) {
                return BS_Rotated_Recursion(arr, element, s, mid - 1);
            } else {
                return BS_Rotated_Recursion(arr, element, mid + 1, e);
            }
        }

        if (element >= arr[mid] && element <= arr[e]) {
            return BS_Rotated_Recursion(arr, element, mid + 1, e);
        } else
            return BS_Rotated_Recursion(arr, element, s, mid - 1);
    }
}

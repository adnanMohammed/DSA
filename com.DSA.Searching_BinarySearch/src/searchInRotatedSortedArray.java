public class searchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,1};
        System.out.println(search(arr, 1));
    }

    public static int search(int[] nums, int target) {
        int peak = pivotElement(nums);//log N
        int res = BinarySearch(nums, target, 0, peak);//log N
        if (res == -1) {
                return BinarySearch(nums, target, peak + 1, nums.length - 1);// log N

        } else
            return res;
    }

    public static int BinarySearch(int[] arr, int find, int l, int h) {
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

    private static int pivotElement(int[] arr) {
        if (arr.length == 1) {
            return arr.length - 1;
        }
        if (arr.length == 2) {
            if (arr[0] > arr[1])
                return arr[0];
            else
                return arr[1];
        }

        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[s] < arr[mid]) {
                s = mid + 1;
            } else if (arr[mid] < arr[e]) {
                e = mid - 1;
            }
        }
        return -1;
    }




   /* private static int pivotElement(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[s] >= arr[mid]) {
                e = mid - 1;
            } else if (arr[s] < arr[mid]) {
                s = mid + 1;
            }
        }
        return -1;
    }*/

}

public class first_last_posInAnArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 6, 7, 7, 7, 7, 7, 9, 9, 9, 9, 10};
        int l = 0, h = arr.length - 1;
        int target = 7;
        boolean available = false;
        for (int i:searchRange(arr, target)) {
            System.out.print(i+" ");
        }
    }

    public static int[] searchRange(int[] nums, int target) {
       int start= firstPos(nums,target,0,nums.length-1,false);
        int end=secondPos(nums,target,0,nums.length-1,false);

        int[] result={start,end};
        return result;

    }

    private static int secondPos(int[] arr, int target, int l, int h, boolean available) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (target == arr[mid]) {
                available = true;
                l = mid + 1;
                return secondPos(arr, target, l, h, available);
            } else if (target < arr[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (available) {
            return h;
        } else {
            return -1;
        }
    }

    private static int firstPos(int[] arr, int target, int l, int h, boolean available) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (target == arr[mid]) {
                available = true;
                h = mid - 1;
                return firstPos(arr, target, l, h, available);
            } else if (target < arr[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (available) {
            return l;
        } else {
            return -1;
        }
    }

}

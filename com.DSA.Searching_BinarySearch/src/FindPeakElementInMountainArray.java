public class FindPeakElementInMountainArray {

    public static void main(String[] args) {
        int[] nums={1,2,1,3,5,6,4};
        System.out.println( findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 2] < nums[n - 1])
            return n-1;

        int s = 1;
        int e = nums.length - 2;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid + 1])
                s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
}

public class isSortedInRotatedArray {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        //  int[] nums1 = {6,10,6};
        System.out.println(isSortedInRotatedArray(nums1)); // Output: true
    }

    private static boolean isSortedInRotatedArray(int[] nums) {
        //Find min element in an array
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = i;
                break;
            }
        }


        for (int i = 1; i <nums.length ; i++) {
            int start=(min+i)%nums.length;
            if(nums[start]<nums[(start-1+nums.length)% nums.length]){
                return false;
            }
        }

        return true;

    }
}

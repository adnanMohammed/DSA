public class zeros_ones_twos {
    public static void main(String[] args) {
        int[] nums={2};
        sortColors(nums);
    }


    public static void sortColors(int[] nums) {
        int low=0,mid=0,high= nums.length-1;

        while (mid<=high){
            if (nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1)
                mid++;
            else {
                swap(nums,mid,high);
                high--;
            }

        }
    }

    private static void swap(int[] nums, int low, int mid) {
        if (low != mid) {
            nums[low] = nums[low] + nums[mid];
            nums[mid] = nums[low] - nums[mid];
            nums[low] = nums[low] - nums[mid];

        }
    }
}

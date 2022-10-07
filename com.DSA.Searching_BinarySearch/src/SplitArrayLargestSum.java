public class SplitArrayLargestSum {

    public static void main(String[] args) {
        // int[] nums = {7, 2, 5, 10, 8};
        int[] nums = {1, 4,4};
        int m = 3;
        System.out.println(splitArray(nums, m));
    }


    //leetCode Hard:-410. Split Array Largest Sum
    public static int splitArray(int[] nums, int m) {
        //case 1
        int max = 0;
        for (int i : nums) {
            max += i;
        }
        //case 2
        int maxElement = nums[0];
        for (int i : nums) {
            if (maxElement < i) {
                maxElement = i;
            }
        }
        int s = maxElement;//min Range
        int e = max;//Max Range

        while (s < e) {
            int mid = (s + e) / 2;
            int sum = 0;
            int piece = 1;
            for (int i : nums) {
                if ((sum + i) <= mid) {
                    sum += i;
                } else {
                    sum = i;
                    piece += 1;
                }
            }
            if (piece <= m) {
                e = mid;
            } else if (piece > m) {
                s = mid + 1;
            }
        }
        return s;
    }

}

public class EvenNumDigitInArray {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896,0};
        System.out.println(evenNumberOfDigits(nums));
    }

    public static int evenNumberOfDigits(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int intCount = 0;
            if (nums[i] < 0) {
                nums[i] = nums[i] * -1;
            }
            if(nums[i]==0){
                continue;
            }
            while (nums[i] > 0) {
                intCount += 1;
                nums[i] = nums[i] / 10;

            }
            if (intCount % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }
}

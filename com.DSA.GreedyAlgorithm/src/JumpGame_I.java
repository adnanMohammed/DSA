public class JumpGame_I {
    public boolean canJump(int[] nums) {
        //your code goes here
        int length = nums.length;
        int lastIndex = length - 1;
        int maxIndex = 0;
        int i = 0;

        while (i < nums.length - 1) {
            int count = i + nums[i];
            maxIndex = Math.max(count, maxIndex);
            if (maxIndex >= lastIndex)
                return true;

            i++;
        }
        return false;
    }

    public int jump(int[] nums) {


        int jump = 0, L = 0, R = 0, lastIndex = nums.length - 1;

        while (R < lastIndex) {
            int maxLength=0;
            while (L <= R) {
                maxLength = Math.max(L + nums[L], maxLength);
                L++;
            }
            L = R + 1;
            R = maxLength;
            jump+=1;
        }
        return jump;
    }
}

class JumpGame_IMain{
    public static void main(String[] args) {
        JumpGame_I j=new JumpGame_I();
        int[] nums={2,3,1,1,4};
      int res=  j.jump(nums);
    }
}

import java.util.Arrays;

public class TargetArrayInGivenOrder {
    public static void main(String[] args) {
        int[] nums = {4,2,4,3,2};
        int[] index = {0,0,1,3,1};
        System.out.println(Arrays.toString(TargetArray(nums,index)));
    }

    public static int[] TargetArray(int[] nums,int[] index){
        int[] target=new int[nums.length];
            for(int i=0;i<nums.length;i++){
                if (nums[index[i]]!=i){
                    int store=nums[i];
                    for(int j=i;j>index[i];j--) {
                        target[j] = target[j - 1];
                    }
                        target[index[i]]=store;

                }
                else{
                    target[i]=nums[index[i]];

                }
            }
            return target;
    }
}

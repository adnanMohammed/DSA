import java.util.HashMap;

public class longestSubarrayCountWithSumK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 1, 1};
        int n = a.length;
        int k = 3;
        System.out.println(   longestSubarrayWithSumKMet(a, k));
    }

    //O(n) time complexity
    public static int longestSubarrayWithSumKMet(int[] nums, int k) {
        // Write your code here
        HashMap<Integer,Integer> indexValueSum=new HashMap<>();
        int sum=0; int maxArrayLength=0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (sum==k){
                maxArrayLength=i+1;
            }
            if(!indexValueSum.containsKey(sum)) {
                indexValueSum.put(sum, i);
            }
            int key= (int) (sum-k);
            if (indexValueSum.containsKey(key)){
                int res=indexValueSum.get(key);
                maxArrayLength= Math.max(maxArrayLength,i-res);
            }

        }
        return maxArrayLength;
    }
}

import java.util.ArrayList;
import java.util.List;

public class combinationSUMIV {
    public static void main(String[] args) {
        int[] nums = {1,2,3}; int target = 32;
        System.out.println(  combinationSum4(nums,target));

    }
    public static int combinationSum4(int[] nums, int target) {
        List<List<Integer>> li=new ArrayList<>();
     return   combinationSum4_helpercount(target,new ArrayList<Integer>(),nums);
    //return li.size();
    }

    public static void combinationSum4_helper(int target, List<List<Integer>> li,List<Integer> l, int[] arr){
        if(target==0){
            System.out.print(l+",");
            li.add(new ArrayList<>(l));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(target<arr[i])
                continue;
            l.add(arr[i]);
            combinationSum4_helper(target-arr[i],li,l,arr);
            l.remove(l.size()-1);
        }
    }

    public static int combinationSum4_helpercount(int target,List<Integer> l, int[] arr) {
        int count1 = 0;
        if (target == 0) {
            return 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (target < arr[i])
                continue;
            l.add(arr[i]);
            count1 = count1 + combinationSum4_helpercount(target - arr[i], l, arr);
            l.remove(l.size() - 1);
        }
        return count1;
    }
}

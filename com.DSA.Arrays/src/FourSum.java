import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
    int[] nums={1000000000,1000000000,1000000000,1000000000};
    fourSum(nums,-294967296);
    }

    public static List<List<Integer>> fourSum(int []nums, int target) {
        // Write your code here.
        Arrays.sort(nums);
        List<List<Integer>> outerlist=new ArrayList<>();


        int n=nums.length;
        for (int i = 0; i < n-3 ; i++) {
            while(i>0 && i<n-3 && nums[i]==nums[i-1])
                i++;
            for (int j = i+1; j < n-2 ; j++) {
                while(j>0 && j<n && i!=j-1 && nums[j]==nums[j-1])
                    j++;
                int k=j+1; int l=n-1;
                while(k<l){
                    int res=0;
                    if((nums[i]<Integer.MAX_VALUE && nums[i]>Integer.MIN_VALUE) && (nums[j]<Integer.MAX_VALUE && nums[j]>Integer.MIN_VALUE) && (nums[k]<Integer.MAX_VALUE && nums[k]>Integer.MIN_VALUE) && (nums[l]<Integer.MAX_VALUE && nums[l]>Integer.MIN_VALUE)){
                        if((nums[i]+nums[j]<Integer.MAX_VALUE && nums[i]+nums[j]>Integer.MIN_VALUE) && (nums[k]+nums[l]<Integer.MAX_VALUE && nums[k]+nums[l]>Integer.MIN_VALUE) ){
                            res=nums[i]+nums[j]+nums[k]+nums[l];
                        }
                    }

                    if(res==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);list.add(nums[l]);
                        outerlist.add(list);
                        k++;
                        while (k<l && nums[k]==nums[k-1]){
                            k++;
                        }
                        while(l>i && nums[l]==nums[l-1]){
                            l--;
                        }
                    }
                    else if(res<target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return outerlist;
    }
}

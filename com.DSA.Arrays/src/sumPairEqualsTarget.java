import java.util.*;

public class sumPairEqualsTarget {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        int target = 12;
       List<int[]> l= findSumPairs(nums,target);
        for (int[] i:l) {
            System.out.print( Arrays.toString(i));
        }

        /*Map<Integer,int[]> m=sumPair(arr,10);

        for (Map.Entry<Integer,int[]> entry : m.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
         for(int[] a1:m.values()){
             System.out.println(Arrays.toString(a1));
         }*/
    }

    //O(N2) Time complexity
    public static Map sumPair(int[] arr,int target) {
        Map<Integer,int[]> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    m.put(count, new int[]{arr[i], arr[j]});
                    count += 1;
                }
            }
        }
        return m;
    }

    //optimized sol using Collection Set;
    public static List findSumPairs(int[] nums, int target) {
        List<int[]> l=new ArrayList();
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (s.contains(complement)) {
                System.out.println("(" + num + ", " + complement + ")");
                l.add(new int[]{num,complement});
            }
            s.add(num);
        }
        return l;
    }

    //optimized sol without using set or hashmap or collection framework
    public static void findSumPairsOpt(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array in ascending order

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                System.out.println("(" + nums[left] + ", " + nums[right] + ")");
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }


}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletPairEqualsTarget {
    public static void main(String[] args) {
        int[] nums = {1,2, 2, 3,3,3, 4, 5,5, 6, 7,7,7,7};
        int target = 12;

        List<List<Integer>> triplets = findTriplets(nums, target);

        if (triplets.isEmpty()) {
            System.out.println("No triplets found.");
        } else {
            System.out.println("Triplets found:");
            for (List<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        }
    }

    public static List<List<Integer>> findTripletsGPT(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate values
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++; // Skip duplicate values
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--; // Skip duplicate values
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }


    public static List<List<Integer>> findTriplets(int[] nums, int target) {
        List<List<Integer>> tripletsAll = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                if (i>0 && nums[i] == nums[i-1]) {
                    break;
                }

                int tripletSum = nums[i] + nums[left] + nums[right];
                if (tripletSum == target) {
                    System.out.println("[" + nums[i] + "," + nums[left] + "," + nums[right] + "]");
                    List<Integer> triplets = new ArrayList<Integer>();
                    triplets.add(nums[i]);
                    triplets.add(nums[left]);
                    triplets.add(nums[right]);
                    tripletsAll.add(triplets);
                    left++;
                    right--;
                    while (left<right && nums[left - 1] == nums[left])
                        left++;
                    while (left<right && nums[right] == nums[right + 1])
                        right--;
                } else if (tripletSum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return tripletsAll;
    }
}

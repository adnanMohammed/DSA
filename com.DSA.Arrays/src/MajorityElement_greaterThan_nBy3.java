import java.util.*;

public class MajorityElement_greaterThan_nBy3 {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 1, 1, 3, 1, 1};
        int n = arr.length;
        majorityElementoptimialSolution(arr);
    }

    //optimalSolution O(N)
    public static List<Integer> majorityElementoptimialSolution(int[] nums) {
        int element1 = 0, element2 = 0, count1 = 0, count2 = 0;
        int n = nums.length;
        int majorElement = n / 3;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2++;
            } else if (nums[i] == element1)
                count1++;
            else if (nums[i] == element2)
                count2++;

            else {
                count1--;
                count2--;
            }

        }
        int elecount1 = 0, elecount2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element1)
                elecount1++;
            else if (nums[i] == element2)
                elecount2++;
        }
        if (elecount1 > majorElement)
            l.add(element1);
        if (elecount2 > majorElement)
            l.add(element2);
        return l;
    }

    public static List<Integer> majorityElementoptimialSolutionBruteForceSol(int[] v) {
        Arrays.sort(v);
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int n = v.length;
        if (n < 2) {
            list.add(v[0]);
            return list;
        }
        if (n < 3) {
            list.add(v[0]);
            if (!list.contains(v[1]))
                list.add(v[1]);
            return list;
        }
        for (int i = 1; i < v.length; i++) {
            if (v[i] == v[i - 1]) {
                count += 1;
                if (count > Math.floor(n / 3)) {
                    if (!list.contains(v[i]))
                        list.add(v[i]);
                }
            } else count = 1;
        }
        return list;
    }

    public static List<Integer> majorityElementoptimialSolutionBruteForce(int[] v) {
        Map<Integer, Integer> majElement = new HashMap<>();
        List<Integer> majorityElement = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            if (majElement.containsKey(v[i])) {
                majElement.put(v[i], majElement.get(v[i]) + 1);
                if (majElement.get(v[i]) > Math.floor(v.length / 3)) {
                    if (!majorityElement.contains(v[i]))
                        majorityElement.add(v[i]);
                }
            } else {
                majElement.put(v[i], 1);
                if (majElement.get(v[i]) > Math.floor(v.length / 3)) {
                    if (!majorityElement.contains(v[i]))
                        majorityElement.add(v[i]);
                }
            }
        }

        return majorityElement;
    }


}

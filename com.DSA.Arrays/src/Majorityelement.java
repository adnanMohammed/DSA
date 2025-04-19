import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Majorityelement {
    public static void main(String[] args) {
        int[] arr = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        int n = arr.length;
        mooresVotingAlgo_MajorityElement(arr);
    }

    public static int majorityElement(int[] v) {
        // Write your code here
        int k = v.length / 2;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            if (m.containsKey(v[i])) {
                m.put(v[i], m.get(v[i]) + 1);
                if (m.get(v[i]) > k)
                    return v[i];
            } else {
                m.put(v[i], 1);
                if (m.get(v[i]) > k)
                    return v[i];
            }
        }
        return -1;
    }

    public static int majorityElementwithoutMap(int[] v) {
        Arrays.sort(v);
        int value = 0;
        int count = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != value) {
                value = v[i];
                count += 1;
            } else {
                count += 1;
            }
            if (count > (v.length / 2))
                return v[i];
        }
        return -1;
    }

    //answer definitely exists else we need to run another for loop to check if elements count>n/2
    public static int mooresVotingAlgo_MajorityElement(int[] v) {
        int element = 0;
        int count = 0;

        for (int i = 0; i < v.length; i++) {
            if (count == 0) {
                element = v[i];
                count++;
            } else if (v[i] == element)
                count += 1;
            else count--;
        }
        return element;
    }

}

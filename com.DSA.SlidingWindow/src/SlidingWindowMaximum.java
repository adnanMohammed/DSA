import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindowOptimal(int[] nums, int k) {
        List<Integer> listmax = new ArrayList<>();
        List<Integer> listans = new ArrayList<>();

        int L = 0, R = 0, n = nums.length;

        while (R < n) {
            if (listmax.isEmpty())
                listmax.add(nums[R]);
            else {
                while (!listmax.isEmpty() && nums[R] > listmax.get(0))
                    listmax.remove(0);

                listmax.add(nums[R]);
            }

            if (R - L + 1 < k)
                R++;

            else {
                listans.add(listmax.get(0));
                if (nums[L] == listmax.get(0))
                    listmax.remove(0);

                L++;
                R++;
            }
        }
        return listans.stream().mapToInt(i->i).toArray();
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        int L = 0, R = 0, n = nums.length;
        List<Integer> l = new ArrayList<>();
        int[] ans=new int[nums.length-k+1];
        int add=0;
        List<Integer> ansl = new ArrayList<>();
        while (R < n) {
            l.add(nums[R]);

            if (R - L + 1 < k) {

                R++;
            } else {
                Collections.sort(l);

                ans[add++]=l.get(l.size()-1);
                l.remove(l.indexOf(nums[L]));
                L++;
                R++;
            }
        }
        return ans;
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        int L = 0, R = 0, n = nums.length;
        List<Integer> l = new ArrayList<>();
        List<Integer> l_ans = new ArrayList<>();

        while (R < n) {
            while (!l.isEmpty() && l.get(l.size() - 1) < nums[R])
                l.remove(l.size() - 1);

            l.add(nums[R]);
            if (R - L + 1 < k)
                R++;

          else  if (R - L + 1 == k) {
                l_ans.add(l.get(0));
                if (nums[L] == l.get(0))
                    l.remove(0);

                L++;
                R++;
            }
        }
        return l_ans.stream().mapToInt(i -> i).toArray();
    }

    public int subarraySum(int[] nums, int k) {
        int L = 0, R = 0, n = nums.length;
        int sum = 0;
        int maxLength = 0;
        while (R < n) {
            sum += nums[R];
            while (L<n && sum > k) {
                sum -= nums[L];
                L++;
            }
            if (sum == k)
                maxLength = Math.max(maxLength, R - L + 1);

            R++;
        }
        return maxLength;
    }
}

class SlidingWindowMaximumMain{
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        int k = 3;
        SlidingWindowMaximum m = new SlidingWindowMaximum();
        int ans = m.subarraySum(nums, k);

    }
}

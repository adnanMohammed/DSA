import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxLengthSubArrayWithMost2TypeNum {
    public int totalFruits(int[] fruits) {
        //your code goes here
        int type1 = -1;
        int type2 = -1;
        int maxLength = 0;
        int n = fruits.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            for (j = i; j < n; j++) {
                if (type1 == -1)
                    type1 = fruits[j];
                else if (type2 == -1 && fruits[j] != type1)
                    type2 = fruits[j];
                else if (fruits[j] != type1 && fruits[j] != type2)
                    break;
            }
            maxLength = Math.max(maxLength, j - i);
            type1=-1;type2=-1;
        }
        return maxLength;
    }

    public int totalFruits1(int[] fruits) {
        int L = 0, R = 0, maxLength = 0, sum = 0, n = fruits.length;
        Map<Integer, Integer> m = new HashMap<>();

        while (R < n) {
            if (m.containsKey(fruits[R])) {
                m.put(fruits[R], m.get(fruits[R]) + 1);
                sum++;
                R++;
                maxLength = Math.max(maxLength, sum);
            } else if (m.size() < 2) {
                m.put(fruits[R], 1);
                sum++;
                R++;
                maxLength = Math.max(maxLength, sum);
            } else {
                while (m.size() == 2) {
                    m.put(fruits[L], m.get(fruits[L]) - 1);
                    sum--;
                    L++;

                    Set<Integer> s = m.keySet();
                    for (int i : s) {
                        if (m.get(i) == 0) {
                            m.remove(i);
                            break;
                        }
                    }

                }
            }
        }

        return maxLength;
    }
}


class MaxLengthSubArrayWithMost2TypeNumMain {
    public static void main(String[] args) {
        MaxLengthSubArrayWithMost2TypeNum n = new MaxLengthSubArrayWithMost2TypeNum();
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        n.totalFruits1(fruits);
    }
}
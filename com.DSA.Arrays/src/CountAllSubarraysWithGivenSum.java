import java.util.HashMap;
import java.util.Map;

public class CountAllSubarraysWithGivenSum {

    public static void main(String[] args) {
        int[] arr={3,1,2,4}; int s=6;
        findAllSubarraysWithGivenSumOpt(arr,s);
    }

    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.    
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (sum == s)
                count++;
            for (int j = i + 1; j < arr.length; j++) {
                    sum += arr[j];
                    if (sum == s)
                        count++;
            }
        }
        return count;
    }

    public static int findAllSubarraysWithGivenSumOpt(int arr[], int s) {
        // Write your code here.
        Map<Integer, Integer> m = new HashMap();
        int sum = 0;
        int count = 0;
        m.put(sum,1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (m.containsKey(sum - s)) {
                count += m.get(sum - s);
            }
            if(m.containsKey(sum)){
                if(sum!=0)
                m.put(sum,m.get(sum)+1);
            }
            else{
                m.put(sum,1);
            }

        }
        return count;
    }
    
}

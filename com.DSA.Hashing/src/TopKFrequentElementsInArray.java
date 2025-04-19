import java.util.*;

public class TopKFrequentElementsInArray {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topK(nums, k)));
    }

    public static int[] topK(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for (int num: nums) {
            m.put(num,m.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> lst=new ArrayList<Map.Entry<Integer, Integer>>(m.entrySet());

        Collections.sort(lst, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue()==o2.getValue()){
                   return o2.getKey()-o1.getKey();
                }
                else return o2.getValue()-o1.getValue();
            }
        });
        int[] arr=new int[k];

        for (int i = 0; i <k ; i++) {
            arr[i]=lst.get(i).getKey();

        }
        return arr;

    }
}

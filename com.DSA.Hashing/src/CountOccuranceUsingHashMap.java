import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountOccuranceUsingHashMap {

    public static void main(String[] args) {

        int[] arr = new int[]{12, 3, 1, 1, 2, 3, 2, 12};
        int[] occurance = new int[]{1, 2, 3, 4, 12};
      //  numOccuranceUsingHashMap(arr, occurance);
    //    characterHashing("ecdcabaabb");
        String[] str={"Javed","Nasir","Javed","Faisal","Nasir","Adnan","Javed","Nasir","Adnan"};
        StringHashing(str);
    }

    private static void StringHashing(String[] str) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for (String c:str) {
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else m.put(c, 1);

        }
        for (String i:m.keySet()){
            System.out.println(i+" occurs ="+m.get(i)+" times");
        }

    }

    private static void characterHashing(String str) {
        char[] ch = str.toCharArray();
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (char c : ch) {
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else m.put(c, 1);
        }
        for (char i:m.keySet()){
            System.out.println(i+" occurs ="+m.get(i)+" times");
        }
    }

    public static void numOccuranceUsingHashMap(int[] arr, int[] occurance) {

        Map<Integer, Integer> m = new HashMap<>();
        for (int findOccurance : arr) {
            if (m.containsKey(findOccurance)) {
                m.put(findOccurance, m.get(findOccurance) + 1);
            } else m.put(findOccurance, 1);
        }

        for (int findOccurance : occurance) {
            if (m.containsKey(findOccurance))
                System.out.println(findOccurance + " occurs " + m.get(findOccurance) + " times");
            else
                System.out.println(findOccurance + " occurs 0 times");
        }
    }

}

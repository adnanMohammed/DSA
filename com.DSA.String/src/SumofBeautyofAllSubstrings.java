import java.util.*;

public class SumofBeautyofAllSubstrings {

    public int beautySum(String s) {
        int n=s.length();
        int resultCount=0;
        for (int i = 0; i < n; i++) {
            String substring="";
            Map<Character,Integer> m=new HashMap<>();
            for (int j = i; j <n ; j++) {
                substring=substring+s.charAt(j);
                m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
                if(substring.length()>=3) {


                    List<Map.Entry<Character, Integer>> l = new ArrayList(m.entrySet());
                    Collections.sort(l, new Comparator<Map.Entry<Character, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                            return o2.getValue() - o1.getValue();
                        }
                    });

                    int diff = l.get(0).getValue() - l.get(l.size() - 1).getValue();
                    if (diff >= 1)
                        resultCount += diff;
                }

            }
        }
        return resultCount;
    }

}


class SumofBeautyofAllSubstringsMain{
    public static void main(String[] args) {
        SumofBeautyofAllSubstrings s=new SumofBeautyofAllSubstrings();
        String str = "aabcb";
        System.out.println(s.beautySum(str));
    }
}
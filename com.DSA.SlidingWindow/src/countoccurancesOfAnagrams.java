import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class countoccurancesOfAnagrams {

    public static void main(String[] args) {
        String str="forxxorfxdofr"; String pattern="for";
        System.out.println(countAnagramOccurance1(str,pattern));
    }

    public static int countAnagramOccurance1(String str, String pattern) {
        int L = 0, R = 0, n = str.length();
        int count = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
            m.put(pattern.charAt(i), m.getOrDefault(pattern.charAt(i), 0) + 1);

        while (R < n) {
            if (m.containsKey(str.charAt(R)))
                m.put(str.charAt(R), m.get(str.charAt(R)) - 1);
            if (R - L + 1 == pattern.length()) {
                Collection<Integer> c = m.values();
                int mapZeroCount=0;
                for (int i : c) {
                    if (i == 0)
                        mapZeroCount++;
                }
                if(mapZeroCount==m.size())
                    count++;

                if (m.containsKey(str.charAt(L)))
                    m.put(str.charAt(L), m.get(str.charAt(L)) + 1);

                L++;
            }
            R++;
        }
        return count;
    }



    public static int countAnagramOccurance(String str, String pattern){
        int n=str.length(); int k=pattern.length(); int i=0,j=0;int count=0; int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        while (!pattern.isEmpty()) {
            if (map.containsKey(pattern.charAt(0)))
                map.put(pattern.charAt(0), map.get(pattern.charAt(0)) + 1);
            else map.put(pattern.charAt(0), 1);

            pattern=pattern.substring(1);
        }
        count=map.size();
        while (j<n){
            if(count==0)
                ans+=1;
            if(map.containsKey(str.charAt(j))){
                if(map.get(str.charAt(j))==0){
                    map.put(str.charAt(j),1);
                    count+=1;
                }
                map.put(str.charAt(j),map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j))==0)
                    count-=1;
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(map.containsKey(str.charAt(i))){
                 if(map.get(str.charAt(i))==0)
                     count+=1;
                 map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }
                i++; j++;
            }
        }
        return ans;
    }
}

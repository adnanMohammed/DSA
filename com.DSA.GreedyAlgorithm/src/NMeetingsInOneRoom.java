import java.util.*;

public class NMeetingsInOneRoom {
    public int maxMeetings1(int[] start, int[] end) {

        List<int[]> l=new ArrayList<>();
        for (int i = 0; i < start.length ; i++) {
            l.add(new int[]{start[i],end[i]});
        }

        l.sort((o1, o2) -> o1[1]-o2[1]);

        int limit = l.get(0)[1];

        int count = 1;

        for (int i = 1; i < start.length; i++) {
            /*If the current meeting starts
            after the last selected meeting ends*/
            if (l.get(i)[0] > limit) {
                /*Update the limit to the end
                time of the current meeting*/
                limit = l.get(i)[1];
                // Increment count
                count++;
            }
        }

        return count;

    }
    public int maxMeetings(int[] start, int[] end) {
        //your code goes here
        Map<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < start.length; i++) {
            if (m.containsKey(start[i])) {
                if (m.get(start[i]) > end[i])
                    m.put(start[i], end[i]);
            } else
                m.put(start[i], end[i]);
        }

        Map<Integer, Integer> sortedMap = sortByValue(m);
        int startLimit = 0;
        int totalMeetings = 0;
        Set<Integer> mapkey = sortedMap.keySet();
        for (Integer key : mapkey) {
            if (key > startLimit) {
                totalMeetings++;
                startLimit = sortedMap.get(key);
            }

        }
        return totalMeetings;
    }

    public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        // Create a list from map entries
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list using a lambda expression (comparator based on values)
        list.sort(Map.Entry.comparingByValue());

        // Create a new LinkedHashMap to store the sorted entries
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}

class NMeetingsInOneRoomMain {
    public static void main(String[] args) {
        NMeetingsInOneRoom nm = new NMeetingsInOneRoom();
        int[] Start = {0, 3, 1, 5, 5, 8}, End = {5, 4, 2, 9, 7, 9};

        System.out.println(nm.maxMeetings1(Start, End));

    }
}

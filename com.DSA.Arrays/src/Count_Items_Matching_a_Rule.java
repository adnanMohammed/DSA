import java.util.ArrayList;
import java.util.List;

public class Count_Items_Matching_a_Rule {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<List<String>>();
        List<String> l = new ArrayList<String>();
        l.add("phone");
        l.add("blue");
        l.add("pixel");

        List<String> l1 = new ArrayList<String>();
        l1.add("computer");
        l1.add("silver");
        l1.add("phone");

        List<String> l2 = new ArrayList<String>();
        l2.add("phone");
        l2.add("gold");
        l2.add("iphone");

        String ruleKey = "type", ruleValue = "phone";

        items.add(l);
        items.add(l1);
        items.add(l2);

        countMatches(items, ruleKey, ruleValue);
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        if (ruleKey.equals("type")) {
            for (List<String> l1 : items) {
                if (l1.get(0).equals(ruleValue))
                    count += 1;
            }
        } else if (ruleKey.equals("color")) {
            for (List<String> l1 : items) {
                if (l1.get(1).equals(ruleValue))
                    count += 1;
            }
        } else {
            for (List<String> l1 : items) {
                if (l1.get(2).equals(ruleValue))
                    count += 1;
            }
        }
        return count;
    }
}

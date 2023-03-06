import java.util.ArrayList;
import java.util.List;

public class kidsWithGreatestCandies {

    public static void main(String[] args){
        int[] candies = {2,3,5,1,3}; int extraCandies = 3;

       System.out.println( kidsWithCandies(candies,extraCandies));

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 1; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        for (int i : candies) {
            int sum = i + extraCandies;
            if (sum >= max)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }
}

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int MaximumNonOverlappingIntervals(int[][] Intervals) {
        //your code goes here

        Arrays.sort(Intervals, (o1,o2)->o1[1]-o2[1]);
        int startTime=Intervals[0][1];
        int count=1;

        for (int i = 1; i < Intervals.length; i++) {
            if (Intervals[i][0]>=startTime){
                count++;
                startTime=Intervals[i][1];
            }

        }

        return Intervals.length-count;
    }
}

class NonOverlappingIntervalsMain{
    public static void main(String[] args) {
     NonOverlappingIntervals n=new NonOverlappingIntervals();
       int[][] Intervals = {{1, 2} , {2, 3} , {3, 4} ,{1, 3} };
        System.out.println(  n.MaximumNonOverlappingIntervals(Intervals));
    }
}

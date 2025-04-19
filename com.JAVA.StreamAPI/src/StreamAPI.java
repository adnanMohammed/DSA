import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        Collection<Integer> col = Arrays.asList(1, 5, 2, 9, 3, 8, 7);
        System.out.println(col.stream().reduce(0,(i,j)->i+j));
        IntSummaryStatistics s=col.stream().mapToInt(i->i).summaryStatistics();


  System.out.println(col.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList()));
        Integer[] a = col.toArray(new Integer[col.size()]);
        int[] i1 = col.stream().mapToInt(i -> i).toArray();
        int[] arr = col.stream().filter(i -> i > 2).mapToInt(i -> i).toArray();
        int[] a1 = Arrays.stream(arr).sorted().toArray();

        System.out.println(  col.stream().distinct().skip(1).collect(Collectors.toList()));
        System.out.println(  col.stream().limit(1));
       col.stream().forEach(System.out::println);

    }
}

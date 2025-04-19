import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class map_flatmap {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 5, 3, 7, 2, 9, 6);
        List<Integer> l1 = Arrays.asList(1, 5);
        List<Integer> l2 = Arrays.asList(2, 6, 7);
        List<Integer> l3 = Arrays.asList(3, 7, 8);
        List<Integer> l4 = Arrays.asList(4, 8, 9);
        List<Integer> l5 = Arrays.asList(5, 9, 1);
        List<List<Integer>> ll = Arrays.asList(l1, l2, l3, l4, l5);
        ll.stream().flatMap(li -> li.stream()).forEach(System.out::println);
        System.out.println("------------------");
        ll.stream().map(l22->l22).forEach(System.out::println);

    }
}

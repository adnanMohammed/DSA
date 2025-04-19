import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        Integer[] arr={2,1,3,4,2,3};
        Collection<Integer> col = Arrays.asList(arr);
        col.stream().reduce((i,j)->i+j).ifPresent(System.out::print);
        System.out.println(col.stream().map(i->i).distinct().collect(Collectors.toList()));
        System.out.println( col.stream().skip(1).collect(Collectors.toList()));
        System.out.println(col.stream().map(i->i*1).anyMatch(i->i==1));
        System.out.println(col.stream().map(i->i*1).allMatch(i->i==1));
        System.out.println(col.stream().map(i->i*1).noneMatch(i->i==5));
        List<Integer> tol = col.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        //List<Integer> tol=  col.stream().map(i->i+2).collect(Collectors.toList());
        int cou = (int) (col.stream().filter(m -> m % 2 == 0).count());
        System.out.println(cou);

        Collection<Integer> marks = Arrays.asList(70, 45, 10, 65, 20, 25);
        Integer[] m1=marks.stream().toArray(Integer[]::new);

        Arrays.stream(m1).forEach(i-> System.out.println(i));
        Integer[] a12=marks.stream().toArray(Integer[]::new);
        Consumer c=i->{
            System.out.print(i+",");
        };
        System.out.println("stat");
        marks.stream().forEach(i->System.out.print(i+" "));
        System.out.println();
        List<Integer> i=new ArrayList<>();
        marks.stream().forEach(i1->i.add(i1));
        System.out.println("stat");
        System.out.println("min="+marks.stream().min((i1,i2)->i1.compareTo(i2)).get());

        int cnt = (int) marks.stream().filter(m -> m < 35).count();
        System.out.println("cnt=" + cnt);
        System.out.println(marks.stream().sorted().collect(Collectors.toList()));
        System.out.println(marks.stream().sorted((i1,i2)->(i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList()));
        System.out.println("----------------");
        Collection<String> actors = Arrays.asList("Shahrukh khan","Salman khan","Bobby","Yash","KGF");
        System.out.println(actors.stream().sorted((i1,i2)->i1.length()-i2.length()<0?-1:i1.length()-i2.length()>0?1:0).collect(Collectors.toList()));
        System.out.println(actors.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList()));

        Stream s5=Stream.of(9,4,6,1,9,12,32);
        s5.forEach(System.out::println);
    }
}

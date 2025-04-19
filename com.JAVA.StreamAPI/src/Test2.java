import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        Collection<String> colStr=Arrays.asList("adnan","faisal","nasir","nusrath");
        System.out.println(  colStr.stream().map(i->i).reduce((i,j)->i.length()>j.length()?i:j).get());

        Collection<Integer> col = Arrays.asList(1, 9, 7, 8, 2, 6, 4, 5);
        double s=col.stream().mapToInt(i->i).summaryStatistics().getAverage();
        System.out.println(col.stream().filter((i)->i<5).collect(Collectors.toList()));
        System.out.println(col.stream().mapToInt(i->i).reduce((i,j)->i*j).getAsInt());
        System.out.println( col.stream().mapToInt((i)->i).reduce(Integer::max).getAsInt());
        System.out.println("1="+ col.stream().mapToInt(i -> i).sum());
        System.out.println("2="+ col.stream().mapToInt(i -> i).reduce((i,j)->i+j).getAsInt());
        System.out.println("3="+col.stream().mapToInt(i -> i).reduce(0,(i,j)->i+j));
        System.out.println(Stream.of(2, 1, 3, 9, 2, 13).reduce(10, (i, j) -> i - j));
    }
}

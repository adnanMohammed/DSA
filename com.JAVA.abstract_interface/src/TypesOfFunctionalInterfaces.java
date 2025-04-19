import java.util.function.Consumer;
        import java.util.function.Function;
        import java.util.function.Predicate;
        import java.util.function.Supplier;

public class TypesOfFunctionalInterfaces {
    public static void main(String[] args) {
        Consumer<String> data = (String s) -> {
            System.out.println(s);
        };
        data.accept("HelloWorld");

        Supplier<Integer> val = () -> {
            return 10;
        };
        int res = val.get();

        Function<Integer, Integer> fun = (i) -> {
            if (i % 2 == 0)
                return 1;
            return 0;
        };
        fun.apply(1);

        Predicate<Integer> isEven = (num) -> {
            if (num % 2 == 0)
                return true;
            return false;
        };
        boolean ans = isEven.test(1);
    }
}

@FunctionalInterface
public interface A {
int i=0;
    int operation(int a, int b);

   /* default void show(int a, int b){

    }
    String toString();

    boolean equals(Object o);*/
}

interface B{
    void show();
}

class Main {
    public static void main(String[] args) {

        B b1=()-> System.out.println("adnan");



         /*
     A add=new A(){
       public int add(int a, int b){
            return a+b;
        }
    };

    A add = (a, b) -> {
            return a + b;
        };
     */
        A add = (a, b) ->a + b;

        A sub = (a, b) -> {
            return a - b;
        };
        A mul = (a, b) -> {
            return a * b;
        };
        A div = (a, b) -> {
            return a / b;
        };

        System.out.println(add.operation(1, 2));
        System.out.println(sub.operation(5,6));
        System.out.println(mul.operation(2,3));
        System.out.println(div.operation(9,8));
    }


}

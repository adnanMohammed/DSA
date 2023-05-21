public class InnerClass {
    String name1;
    int age;
    int count;

    static class AinnerClass{
        String name;
        static int i1=10;
        public AinnerClass(String name){
            this.name=name;
        }
    }

    public static void main(String[] args) {
        AinnerClass in=new AinnerClass("adnan");
        AinnerClass in1=new AinnerClass("faisal");
        InnerClass in2=new InnerClass();
        int i1 = AinnerClass.i1;

    }
}

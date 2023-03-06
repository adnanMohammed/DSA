public class mutable_immutable_example {
    public static void main(String[] args) {
        String str = "adnan";//objects assigned in String pool Memory location
        String str2 = "adnan";//objects assigned in String pool Memory location with same reference
        String str3 = new String("adnan");//objects assigned in String pool Memory location as well Memory Heap
        System.out.println(str);
        System.out.println(System.identityHashCode(str));
        System.out.println(str2);
        System.out.println(System.identityHashCode(str2));

        str.concat("adn");//Strings are immutable
        System.out.println(str);//adnan

        //Wrapper classes immutable example
        Integer i = new Integer(20); //initialize a object of Integer class with value as 20.
        System.out.println(i);//20
        System.out.println(System.identityHashCode(i));//address is 1711574013
        i=i+10;
        System.out.println(i);
        System.out.println(System.identityHashCode(i));//address is 1631862159

        //Arrays are mutable in java example
        int[] arr=new int[10];
        arr[0]=1;
        System.out.println(System.identityHashCode(arr[0]));
        arr[1]=2;
        arr[0]=20;
        System.out.println(System.identityHashCode(arr[0]));
        System.out.println(System.identityHashCode(arr[0]));
        System.out.println(System.identityHashCode(arr[0]));



    }



}
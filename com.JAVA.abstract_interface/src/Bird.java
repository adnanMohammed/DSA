@FunctionalInterface
public interface Bird {
    boolean canFly();//abstract method

    //default method
    default void getHeight() {
        //implementation
    }

    //default method
    default void getHeight1() {
        //implementation
    }

    //static method
    static boolean canDrink() {
        //implementation
        return true;
    }

    //static method
    static boolean canSing() {
        //implementation
        return true;
    }

    //Object class methods
    boolean equals(Object o);

    //Object class methods
    String toString();
}



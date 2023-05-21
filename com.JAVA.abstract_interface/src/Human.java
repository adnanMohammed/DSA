public interface Human {

    String name = null;
    String salary = null;

    void canDance();

    default void canEat(){
        System.out.println("eating");
    }

}

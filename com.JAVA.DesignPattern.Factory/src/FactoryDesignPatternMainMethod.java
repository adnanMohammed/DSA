public class FactoryDesignPatternMainMethod {
    public static void main(String[] args) {
       Animal animal= AnimalFactory.getInstance(2);
        System.out.println( animal.canTalk());


    }
}

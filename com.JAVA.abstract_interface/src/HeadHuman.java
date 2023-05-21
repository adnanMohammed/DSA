public class HeadHuman implements Human{

    @Override
    public void canDance() {
        System.out.println("dancing");
    }

    @Override
    public void canEat() {
        Human.super.canEat();
    }
}

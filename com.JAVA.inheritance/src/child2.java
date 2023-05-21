public class child2 extends Parent{
    double weight;

    public child2(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
    }

    @Override
    public void canWork(String day, int time) {
        super.canWork(day, time);
    }

    @Override
    public void canWork() {
        super.canWork();
    }
}

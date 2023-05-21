public class DigitalMedia implements Media{
    @Override
    public void start() {
        System.out.println("I am starting Media Player");
    }

    @Override
    public void stop() {
        System.out.println("I am stopping Media Player");
    }
}

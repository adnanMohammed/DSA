public class Car implements Brake, Engine, Media {

    DigitalMedia media;
    @Override
    public void brake() {
        System.out.println("I am applying brake");

    }

    @Override
    public void start() {
        System.out.println("I am starting the car");
    }

    @Override
    public void stop() {
        System.out.println("I am stopping the car");
    }

    @Override
    public void accelarate() {
        System.out.println("I am applying accelerator");
    }
}

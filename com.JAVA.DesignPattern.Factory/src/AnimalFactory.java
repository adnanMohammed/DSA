public class AnimalFactory {

    private static Animal animalInstance = null;

   public static Animal getInstance(int num) {
        switch (num) {
            case 1:
                animalInstance = new Cat();
                break;
            case 2:
                animalInstance = new Dog();
                break;
            case 3:
                animalInstance = new Parrot();
                break;
            case 4:
                animalInstance = new Sheep();
                break;
            case 5:
                animalInstance = new Donkey();
                break;
        }

        return animalInstance;
    }
}
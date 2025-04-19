public class EagleMainMethod {
    public static void main(String[] args) {
        Bird b = new Bird() {
            @Override
            public boolean canFly() {
                return true;
            }
        };

        Bird eagle = () -> {
            return true;
        };

    }
}

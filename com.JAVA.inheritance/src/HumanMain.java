public class HumanMain {

    public static void main(String[] args) {
        Human h = new Human();
        Boy b = new Boy("gf", "adnan", 27, "RT Nagar");
        b.name = "adnan";
        b.canWork("male");
        Boy male=new Boy("yes", "faisal", 30, "Saudi Arabia");
        male.canSing();

    }
}

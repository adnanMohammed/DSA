
//enum can implement interface but cannot extend class because it already extends Enum class
public enum Day {
    MONDAY(5), TUESDAY(10), WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    int value;
    //constructor
    Day() {
        System.out.println("In Day=" + this);
    }

    //argument constructor
    Day(int value) {
        this.value=value;
        System.out.println("In Day(value)=" + this);
    }

    //instance non static method
    public void getDay() {
        System.out.println("In this Day");
    }
    //static method
    public static void getDayStatic() {
        System.out.println("In this Day static");
    }
    //main method
    public static void main(String[] args) {
        System.out.println(  Day.valueOf("MONDAY"));
        System.out.println(  Day.valueOf("MONDAY").ordinal());
        System.out.println(Day.valueOf("MONDAY").toString());

        for (Day d:Day.values()) {
            System.out.println("Day is="+d+"d's value="+d.value);
        }
    }
}

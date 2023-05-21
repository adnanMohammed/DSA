import java.util.Arrays;

public class MainHuman {

    public static void main(String[] args) throws CloneNotSupportedException {
        Human adnan = new Human("adnan", 27);
        System.out.println("adnan name before=" + adnan.name);
        System.out.println("before adnan arr"+ Arrays.toString(adnan.arr));
        Human faisal = (Human) adnan.clone();
        System.out.println("faisal name before=" + faisal.name);
        System.out.println("before faisal arr"+ Arrays.toString(faisal.arr));
        adnan.name = "Mohammed Adnan";
        faisal.arr[0]=10;
        System.out.println("faisal name after=" + faisal.name);
        System.out.println("adnan name after=" + adnan.name);
        System.out.println("after faisal arr"+ Arrays.toString(faisal.arr));
        System.out.println("after adnan arr"+ Arrays.toString(adnan.arr));
    }
}

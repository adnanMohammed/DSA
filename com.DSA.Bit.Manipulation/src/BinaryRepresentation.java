import java.util.ArrayList;
import java.util.List;

public class BinaryRepresentation {
    public static void main(String[] args) {
        int decimalNumber = 10; // Replace this with your desired decimal number

        // Binary representation with "0b" prefix
        String binaryString = Integer.toBinaryString(decimalNumber);
        System.out.println("Binary representation of " + decimalNumber + " is: 0b" + binaryString);

//        int n=3;
//        System.out.println( generatePowerSets(n));
    }


    public static List<String> generatePowerSets(int n){
        List<String> list=new ArrayList<>();
        int res=(int)Math.pow(2,n);
        for (int i = 0; i < res ; i++) {
           list.add(Integer.toBinaryString(i));
        }
        return list;
    }
}

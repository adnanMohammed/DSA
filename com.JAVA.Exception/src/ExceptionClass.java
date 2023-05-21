import java.io.IOException;
import java.sql.SQLException;

public class ExceptionClass {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        // int res=a/b;
    }
     void divide(int a, int b) throws SQLException {
        if (b == 0) {
            throw new SQLException("throwing an Arithematic Exception");
        } else {
            System.out.println("sssssss");
        }
    }

    void divideNew(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("throwing an Arithematic Exception");
        } else {
            System.out.println("sssssss");
        }
    }

    void calldivideNew(int a, int b) {
        //as divideNew uses runtime Exception i,e.. ArithmeticException no need to add throws or try catch() block
        divideNew(a, b);
    }



     void divideAbove(int a, int b) throws Exception{
         divide(a, b);
    }
}

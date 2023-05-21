public class testCustomException {
    public static void main(String[] args) {
        try {
            int a = 10, b = 0;
            if (b == 0)
                throw new CustomException("ddddddddddd");
            int res = a / b;
        } catch (CustomException C) {
            System.out.println("In CustomException");
            C.getMessage();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}

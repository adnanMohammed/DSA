public class printNto1 {
    public static void main(String[] args) {
    int N=5;
        printNto1(N);
    }
   public static void printNto1(int N){
        if(N==1){
            System.out.print(N);
            return;
        }
        else{
            System.out.print(N+" ");
            printNto1(N-1);
        }

   }
}

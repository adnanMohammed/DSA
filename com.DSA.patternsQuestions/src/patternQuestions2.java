public class patternQuestions2 {
    public static void main(String[] args) {
        pattern31(4);

    }

    private static void pattern31(int n) {
        int p=2*n+1;
        for (int row = 1; row <= (2*n)-1; row++) {
            int dec=row<=n?row-1:((2*n)-1-row);
            int red=n;
            for (int i = 0; i <dec; i++) {
                System.out.print(red+" ");
                red-=1;
            }
            int p1=(row>n)?(p+=2):(p-=2);
            int mid=(row<=n)? (n-row+1):(row-n+1);

            for (int i = 1; i <= p1; i++) {
                System.out.print(mid+" ");
            }
            int dec1= row<=n? row-1: (2*n-1-row);
            int red1=n-dec1+1;
            for (int i = 0; i <dec1; i++) {
                System.out.print(red1+" ");
                red1+=1;
            }
            System.out.println();
        }


    }
}

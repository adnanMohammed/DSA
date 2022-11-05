public class AllRecursionBasicQuestions {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(countZeros(0));

    }

    public static int factorial(int n) {
        if (n <= 1)
            return n;
        else
            return n * factorial(n - 1);
    }

    public static int sumOfNto1(int n) {
        if (n <= 1)
            return n;
        else
            return n + sumOfNto1(n - 1);
    }

    public static int sumOfDigits(int n) {
        if ((n / 10) == 0)
            return n;
        else
            return (n % 10) + sumOfDigits(n / 10);
    }

    public static int prodOfDigits(int n) {
        if ((n / 10) == 0)
            return n;
        else
            return (n % 10) * prodOfDigits(n / 10);
    }

    public static int ReverseANumber(int n) {
        if ((n / 10) == 0)
            return n;
        else
            return Integer.parseInt((n % 10) + "" + ReverseANumber(n / 10));
    }

    public static int RevANumByIteration(int num) {
        int rem = 0;
        while (num != 0) {
            rem = rem * 10 + (num % 10);
            num = num / 10;
        }
        return rem;
    }

    public static int RevANumByRecur(int num) {
        return RevANumByRecursion(num, 0);

    }

    public static int RevANumByRecursion(int num, int rem) {
        if (num == 0)
            return rem;
        else {
            rem = rem * 10 + (num % 10);
            return RevANumByRecursion(num / 10, rem);
        }
    }

   public static int countZeros(int num) {
       if (num == 0)
           return 1;
       else
           return countZerosHelper(num, 0);
   }

    public static int countZerosHelper(int num, int count) {
        if (num == 0) {
            return count;
        } else {
            if (num % 10 == 0) {
                count += 1;
            }
            return countZerosHelper(num / 10, count);

        }
    }
}

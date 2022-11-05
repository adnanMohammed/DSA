public class NumberStepsToReachZero {
    public static void main(String[] args) {
        int num = 123;
        System.out.println(numberOfStepsRecursiveSolution(num));
    }

    public static int numberOfStepsRecursiveSolution(int num) {
        int count=0;
        return numberOfStepsRecursiveHelper(num,count);
    }
    public static int numberOfStepsRecursiveHelper(int num,int count){
        if(num==0)
            return count;
        else if(num%2==0)
            return numberOfStepsRecursiveHelper(num/2,count+=1);
        else if(num==1)
            return numberOfStepsRecursiveHelper(num-1,count+=1);
        else
            return numberOfStepsRecursiveHelper((num-1)/2,count+=2);

    }

    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                count += 1;
                num = num / 2;
            } else if (num == 1) {
                num = num - 1;
                count += 1;
            } else if (num % 2 != 0) {
                num = num - 1;
                num = num / 2;
                count += 2;
            }
        }
        return count;
    }
}
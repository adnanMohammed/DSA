public class maxSum {
    public static void main(String[] args) {
        int[][] arr={{1,5},{7,3},{3,5}};
    int out=maxSum2D(arr);
        System.out.println("out="+out);
    }

    private static int maxSum2D(int[][] arr) {
        int max_sum=0;
        for (int i = 0; i < arr.length; i++) {
            int sum=0;
            for(int j=0;j<arr[i].length;j++){
                sum+=arr[i][j];
            }
            if(max_sum<sum)
                max_sum=sum;

        }
        return max_sum;
    }


}

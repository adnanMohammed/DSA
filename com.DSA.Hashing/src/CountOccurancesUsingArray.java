public class CountOccurancesUsingArray {
    public static void main(String[] args) {
        int[] arr={10,5,10,15,10,5};
            OccuranceCountUsingArray(arr);
    }

    public static void OccuranceCountUsingArray(int[] arr){
        boolean[] isOccupied=new boolean[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            int count=1;
            if (isOccupied[i])
                continue;
            isOccupied[i]=true;

            for (int j = i+1; j < arr.length ; j++) {
                if (arr[i]==arr[j] && !isOccupied[j]){
                    count+=1;
                    isOccupied[j]=true;
                }
            }
            System.out.println(arr[i]+" occurs "+count+" time");
        }
    }
}

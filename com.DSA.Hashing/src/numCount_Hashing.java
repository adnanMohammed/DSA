import java.util.Arrays;

public class numCount_Hashing {
    public static void main(String[] args) {
        int[] arr={1,3,2,1,3};
        int[] appearance={1,4,2,3,12};
        int[] ans=numCount(arr,appearance);
    }

    public static int[] numCount(int[] arr,int[] appearance){
        int [] arr1=appearance;
        Arrays.sort(appearance);
        int[] arrtimes=new int[appearance[appearance.length-1]+1 ];
        for (int i:arr) {
                arrtimes[i]+=1;
        }

        for(int i:arr1){
            System.out.println(i+" appears "+arrtimes[i]+" times...");
        }
        return arrtimes;
    }
}

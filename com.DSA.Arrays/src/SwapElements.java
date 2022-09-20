public class SwapElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArray = swapElementswithoutTemp(arr,0,1);
        for(int i:newArray){
            System.out.print(i+" ");
        }
    }

    private static int[] swapElements(int[] arr, int i, int j) {
        int temp=arr[i];
            arr[i]=arr[j];//j
            arr[j]=temp;//i
        return arr;
    }

    private static int[] swapElementswithoutTemp(int[] arr, int i, int j) {
        arr[i]=arr[i]+arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[j];
        return arr;
    }
}

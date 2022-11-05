import java.util.Arrays;

public class bubbleSortUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {7,5,8,1,10};
        System.out.println(Arrays.toString(selectionSort(arr,0,0,0)));
        System.out.println(Arrays.toString(bubbleSortRecursion(arr, arr.length-1,1)));
    }

    private static int[] bubbleSortRecursion(int[] arr, int row, int column) {
        if (row == 0)
            return arr;
        else if (column < row) {
            if (arr[column - 1] > arr[column]) {
                //swap
                arr[column] = arr[column] + arr[column - 1];
                arr[column - 1] = arr[column] - arr[column - 1];
                arr[column] = arr[column] - arr[column - 1];
            }
            return bubbleSortRecursion(arr, row, column + 1);
        } else
            return bubbleSortRecursion(arr, row - 1, 1);

    }


    private static int[] selectionSort(int[] arr, int pos, int column,int min) {
        if(pos== arr.length-1)
            return arr;
        else if(column==arr.length){
            //swap
            if(pos!=min) {
                arr[pos] = arr[pos] + arr[min];
                arr[min] = arr[pos] - arr[min];
                arr[pos] = arr[pos] - arr[min];
            }
            return selectionSort(arr,pos+1,pos+1,pos+1);
        }
        else{
            if(arr[column]<arr[min]){
                return selectionSort(arr,pos,column+1,column);
            }
            else
                return selectionSort(arr,pos,column+1,min);
        }
    }

}

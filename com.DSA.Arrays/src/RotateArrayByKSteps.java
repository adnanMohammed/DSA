import java.util.Scanner;

public class RotateArrayByKSteps {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        RotateArrayByKStepsMySol(arr, k);
        Scanner sc = new Scanner(System.in);
    }

    //My Solution
    public static int[] RotateArrayByKStepsMySol(int[] arr, int k) {
        int[] arr1 = new int[arr.length];
        int inc = 0;
        for (int i = k; i < arr.length; i++) {
            arr1[inc] = arr[i];
            inc = inc + 1;
        }
        for (int i = 0; i < k; i++) {
            arr1[inc] = arr[i];
            inc = inc + 1;
        }
        for (int i :
                arr1) {
            System.out.print(i + " ");

        }
        return arr1;
    }

    //Coding Ninja Solution
    static void rotateArray(int arr[], int n, int k) {
        // storing 1st k elements in temporary array
        int temp[] = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        // shifting remaining elements of the array

        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }

        //storing back the k elements to the orignal array
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
        //printing array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}

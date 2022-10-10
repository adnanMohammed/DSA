import java.util.Arrays;

public class cycleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        int[] a1 = {4, 5, 1, 3, 2, 6};
        System.out.println(Arrays.toString(cycleSort(arr)));
    }

    /*public static int[] cycleSortImp(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] != i + 1) {
                int j = arr[i] - 1;
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }
        return arr;
    }*/

    public static int[] cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[correct] != arr[i]) {
                //swap
                arr[correct] = arr[correct] + arr[i];
                arr[i] = arr[correct] - arr[i];
                arr[correct] = arr[correct] - arr[i];

            } else {
                i++;
            }
        }
        return arr;
    }
}
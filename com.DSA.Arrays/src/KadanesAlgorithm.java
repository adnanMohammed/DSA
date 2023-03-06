public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(KadanesAlgorithmsol(arr));
    }

    public static int KadanesAlgorithmsol(int[] arr) {
        int sumMax = -1;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (sumMax < currSum)
                sumMax = currSum;

            if (currSum < 0)
                currSum = 0;
        }
        return sumMax;
    }



    //contigious subArray Sum O(N2)
    public static int contigiousSubArraySumON2(int[] arr) {
        int sumMax = -1;
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum > sumMax)
                    sumMax = currSum;
            }
        }
        return sumMax;
    }

}

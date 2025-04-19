import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextPermutation {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[] {22,39,8,56,83,142,2,172,80,28,149,140,189,36,200,157,61,36,24,120,68,145,100,200,9,69,137,173,116,56,143,176,185,12,116,176,53,30,192,4,104,10,105,2,84,182,120,88,70,73,67,41,106,77,76,106,4,28,2,133,20,127,102,85,33,140,1,140,137,145,52});
        List<Integer> ans = nextGreaterPermutationCodingNinjas(A);

    }

    public static List< Integer > nextGreaterPermutationCodingNinjas(List< Integer > A) {
        // Write your code here.
        int n = A.size();
        int min = -1;
        int minimum = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                min = i;
                break;
            }
        }
        if (min == -1) {
            Collections.reverse(A);
            return A;
        }

        for (int j = n - 1; j > min; j--) {
            if (A.get(j)>A.get(min)) {
                minimum = j;
            break;
            }
        }
        int store = A.get(min);
        A.set(min, A.get(minimum));
        A.set(minimum, store);

        Collections.reverse(A.subList(min + 1, n));
        return A;
    }





    public void nextPermutation(int[] A) {
        int n = A.length; // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            int start = 0;
            int end = A.length - 1;

            while (start < end) {
                // Swap the elements at start and end indices
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;

                // Move the indices inward
                start++;
                end--;
            }
            return;
        }


        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (A[i] > A[ind]) {
                A[i] = A[i] + A[ind];
                A[ind] = A[i] - A[ind];
                A[i] = A[i] - A[ind];
                break;
            }
        }



        int start = ind + 1;
        int end = n-1;

        while (start < end) {
            // Swap the elements at start and end indices
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;

            // Move the indices inward
            start++;
            end--;
        }



    }

    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int n = A.size(); // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }

        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        // Step 3: reverse the right half:
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
    }
}

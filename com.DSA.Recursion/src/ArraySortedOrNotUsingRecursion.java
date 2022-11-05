public class ArraySortedOrNotUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8};
        System.out.println(isArraySorted(arr));
    }

    private static boolean isArraySorted(int[] arr) {
        int start = 0, end = 1;
        return isArraySortedUsingRecursion(arr, start);
    }

    //My Solution
    public static boolean ArraySortedUsingRecursion(int[] arr, int s) {
        if (arr.length == 1)
            return true;
        if (s == arr.length - 1)
            return true;
        if (arr[s] > arr[s + 1])
            return false;
        else
            return ArraySortedUsingRecursion(arr, s + 1);
    }

    //proper optimized solution
    public static boolean isArraySortedUsingRecursion(int[] arr, int s) {
        //base condition
        if (s == (arr.length - 1))
            return true;
        else
            //recurrance relation
            return (arr[s] < arr[s + 1]) && isArraySortedUsingRecursion(arr, s + 1);
    }
}

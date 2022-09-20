public class MaxElement {
    public static void main(String[] args) {
        int[] arr = {-1 ,-4 ,5 ,8 ,9 ,3 };
        System.out.println("max=" + maxElementinArray(arr));
        System.out.println("min=" + minElementinArray(arr));

        int sum = sumMaxMinElementsInArray(arr, arr.length);
        System.out.println("sum ="+sum);
    }

    public static int sumMaxMinElementsInArray(int[] arr, int n) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        int min = arr[0];
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }
        return max + min;
    }

    public static int maxElementinArray(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static int minElementinArray(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
}

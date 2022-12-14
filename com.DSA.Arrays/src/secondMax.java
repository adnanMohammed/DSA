public class secondMax {
    public static void main(String[] args) {
        int[] arr = {10, 6, 2, 5, 4, 9, 1};
        System.out.println(secondMaxInArray(arr));
    }

    private static int secondMaxInArray(int[] arr) {
        int max = arr[0], secMax = arr[1];
        if (max < secMax) {
            max = max + secMax;
            secMax = max - secMax;
            max = max - secMax;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max) {
                secMax = max;
                max = arr[i];
            }
            if (arr[i] > secMax) {
                secMax = arr[i];
            }
        }
        System.out.println("max =" + max + "secMax =" + secMax);
        return secMax;
    }
}

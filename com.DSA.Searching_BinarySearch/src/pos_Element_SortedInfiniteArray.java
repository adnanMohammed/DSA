public class pos_Element_SortedInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {10, 29, 30, 35};

        System.out.println(posOfAnElementInSortedInfiniteArray(arr, 38));
    }

    private static int posOfAnElementInSortedInfiniteArray(int[] arr, int target) {
        int start = 0, end = 1;
        int pow = 2;
        //while (!(target >= arr[start] && target <= arr[end])) {
          while(target>arr[end]){
            int value = (int) Math.pow(2, pow);
            start = end + 1;
            end = value + end;
            pow += 1;
        }
        return BinarySearching(arr, target, start, end);
    }


    public static int BinarySearching(int[] arr, int find, int l, int h) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (find == arr[mid]) {
                return mid;
            }
            if (find < arr[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


}

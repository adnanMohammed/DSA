import java.util.Arrays;

public class searchElementInSortedRow_ColumnWiseArray {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40}, {15, 25, 35, 45}, {28, 29, 37, 49}, {33, 34, 38, 50}};
        int search = 2;
        System.out.println(Arrays.toString(searchElement(arr, search)));
    }

    private static int[] searchElement(int[][] arr,int search) {
        int r = 0, c = arr.length - 1;
        while (r <= arr.length - 1 && c >= 0) {
            if (arr[r][c] == search)
                return new int[]{r,c};
            else if (search < arr[r][c])
                c--;
            else
                r++;
        }
        return new int[]{-1,-1};
    }


}

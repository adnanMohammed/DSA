import java.util.Arrays;

public class SearchElementInSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int search = 5;
        System.out.println(Arrays.toString(searchElementIn2DArray(arr, search)));
    }

    //Time Complexity logN+logN+LogN=3logN==>O(logN)
    private static int[] searchElementIn2DArray(int[][] arr, int search) {
        int column = (0 + arr.length - 1) / 2;
        int rowStart = 0, rowEnd = arr.length - 1;
        //log N
        while (rowStart < rowEnd && rowStart != rowEnd - 1 && rowEnd != rowStart + 1) {
            int mid = (rowStart + rowEnd) / 2;
            if (arr[mid][column] == search)
                return new int[]{mid, column};
            else if (search > arr[mid][column])
                rowStart = mid;
            else
                rowEnd = mid;
        }

        //log N
        int res[] = binarySearch(arr, search, 0, arr.length - 1, rowStart);
        if (Arrays.toString(res).contains("-1")) {
            //log N
            return binarySearch(arr, search, 0, arr.length - 1, rowEnd);
        } else
            return res;
    }

    public static int[] binarySearch(int[][] arr, int find, int l, int h, int rowStart) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (find == arr[rowStart][mid]) {
                return new int[]{rowStart, mid};
            }
            if (find < arr[rowStart][mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

}

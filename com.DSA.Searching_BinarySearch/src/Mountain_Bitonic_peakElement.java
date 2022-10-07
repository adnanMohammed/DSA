import com.DSA.Searching.MountainArray;

public class Mountain_Bitonic_peakElement {
    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 2, 0};
        System.out.println(peakElement(arr));
    }

    private static int peakElement(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (arr[mid + 1] > arr[mid]) {
                l = mid + 1;
            } else
                h = mid;
        }

        if (l == h)
            return l;
        else
            return -1;

    }

    //LeetCode Hard :-1095. Find in Mountain Array
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, h = mountainArr.length() - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (target < mountainArr.get(mid)) {
                h = mid - 1;
            } else if (target > mountainArr.get(mid)) {
                l = mid + 1;
            } else
                h = mid;
        }

        if (l == h) {
            return l;
        } else
            return -1;
    }
}

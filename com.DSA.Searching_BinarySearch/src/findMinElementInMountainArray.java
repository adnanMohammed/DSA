//LeetCode Hard :-1095. Find in Mountain Array
public class findMinElementInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        int target = 0;
        System.out.println(findInMountainArray(target, arr));

    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int peak = 0;
        int l = 0, h = mountainArr.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (mountainArr[mid] < mountainArr[mid + 1])
                l = mid + 1;
            else
                h = mid;
        }
        peak = l;
        int resultLeft = leftBinarySearch(target, 0, peak, mountainArr);
        if (resultLeft != -1) {
            return resultLeft;
        } else {
            return rightBinarySearch(target, peak + 1, mountainArr.length - 1, mountainArr);
        }
    }

    //int s=0,e=peak;
    public static int leftBinarySearch(int target, int s, int e, int[] mountainArr) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (target == mountainArr[mid]) {
                return leftBinarySearch(target, s, mid, mountainArr);

            } else if (target < mountainArr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        if (s == e && mountainArr[s] == target) {
            return s;
        } else
            return -1;
    }

    //int s=peak+1,e=h; {descending order}
    public static int rightBinarySearch(int target, int s, int e, int[] mountainArr) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (target == mountainArr[mid]) {
               return  rightBinarySearch(target, s, mid, mountainArr);

            } else if (target < mountainArr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        if (s == e && mountainArr[s] == target) {
            return s;
        } else
            return -1;

    }
}

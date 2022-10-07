public class Ceiling_Floor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 12;
        int l = 0, h = arr.length - 1;
        System.out.println(Floor(arr, target, l, h));
    }

    //Ceiling = smallest element in an array which is greater than or equal to target
    // assuming positive numbers in an array
    private static int Ceiling(int[] arr, int target, int l, int h) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (target > arr[mid]) {
                if (target > arr[mid] && target < arr[mid - 1]) {
                    return arr[mid + 1];
                }
                l = mid + 1;
            } else {
                if (arr[mid - 1] < target && arr[mid] > target) {
                    return arr[mid];
                }
                h = mid - 1;
            }
        }
        return -1;
    }
    // assuming positive numbers in an array
    private static int CeilingOptimized(int[] arr, int target, int l, int h) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        if(target>0 && target< arr[arr.length-1])
        {
            return arr[l];
        }
        return -1;
    }

    //floor = greatest element in an array which is smaller than or equal to target
    // assuming positive numbers in an array
    private static int Floor(int[] arr, int target, int l, int h) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        if(target>0 && target< arr[arr.length-1])
        {
            return arr[h];
        }
        return -1;
    }
}

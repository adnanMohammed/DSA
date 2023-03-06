public class peak {

    public static void main(String[] args){
        int[] arr={1,2,3,4,6,9,10,3,2,1};
        System.out.println(peakInMountainArray(arr));
    }

    public static int peakInMountainArray(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < arr[mid + 1])
                s = mid + 1;
            else
                e = mid;
        }
        return s;
    }
}

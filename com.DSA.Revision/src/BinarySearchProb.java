public class BinarySearchProb {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(FindFirstLastpos(arr, 12));

    }

    public static int[] FindFirstLastpos(int[] arr,int target) {
        int first = FindFirstNLastpos(arr, target, false);
        System.out.println("first="+first);
        int last = FindFirstNLastpos(arr, target, true);
        System.out.println("last="+last);
        return new int[]{first, last};
    }

    public static int FindFirstNLastpos(int[] arr, int target,boolean lastpos) {
        int s = 0, e = arr.length - 1;
        if (lastpos) {
            while (s <= e) {
                int mid = (s + e) / 2;
                if (target < arr[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            }
            if (e>=0 && e<arr.length && arr[e] == target)
                return e;
            else return -1;
        } else {
            while (s <= e) {
                int mid = (s + e) / 2;
                if (target > arr[mid])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
            if (s>=0 && s<arr.length && arr[s] == target)
                return s;
            else return -1;
        }
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (target < letters[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return letters[l % letters.length];
    }

    public static char nextGreatestLetterNew(char[] letters, char target) {
        int s = 0, e = letters.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (letters[mid] < target || letters[mid] == target)
                s = mid + 1;
            else e = mid - 1;
        }
        if (s < 0 || s >= letters.length)
            return letters[0];
        return letters[s];

    }

    public static int floorOfaNumber(int[] arr, int target, int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target) {
                s = mid + 1;
            } else e = mid - 1;
        }
        return e;
    }

    public static int ceilingOfaNumberK(int[] arr, int target, int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target) {
                s = mid + 1;
            } else e = mid - 1;
        }
        return s;
    }

    public static int ceilingOfaNumber(int[] arr, int target, int s, int e) {
        if (target < arr[0])
            return 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                s = mid + 1;
            else if (mid > 0 && arr[mid] > target && arr[mid - 1] < target)
                return mid;
            else
                e = mid - 1;
        }
        return -1;
    }



}

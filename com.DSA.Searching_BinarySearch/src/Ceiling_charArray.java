public class Ceiling_charArray {
    public static void main(String[] args) {
        char[] letter = {'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(nextGreatestLetter(letter, 'e'));
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

public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 9, 8};
        int find = 9;
        System.out.println(LinearSearch(arr, find));
        String str = "adnan";
        char c = 'm';
        System.out.println(searchStrings(str, c));
    }

    public static boolean searchString(String str, char c) {
        char[] cr = str.toCharArray();
        for (int i = 0; i < cr.length; i++) {
            if (cr[i] == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchStrings(String str, char c) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private static int LinearSearch(int[] arr, int find) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) return i;
        }
        return -1;
    }


}

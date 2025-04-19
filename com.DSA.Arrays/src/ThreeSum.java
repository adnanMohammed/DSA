import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0};
       // int[] arr={-18, -1, -44, -48 ,-9, -16, -36, -13 ,29, 17 ,-12, 9, -49};
        int size = arr.length;
        tripletOpt(size, arr);
    }

    private static List<List<Integer>> tripletOpt(int n, int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list1=new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            int k = n - 1;
            while (i > 0 && i < n && arr[i] == arr[i - 1]) {
                i++;
            }
            int j = i + 1;

            while (j < k) {
                int res = arr[i] + arr[j] + arr[k];
                if (res == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    list1.add(list);
                    j++;
                    while (arr[j] == arr[j-1] && j<n)
                        j++;
                } else if (res > 0)
                    k--;
                else
                    j++;

            }
        }
        return list1;
    }

    public static List<List<Integer>> tripletbetter(int n, int[] arr) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            Set<Integer> s = new HashSet();
            for (int j = i + 1; j < n; j++) {
                List<Integer> l = new ArrayList<>();
                int check = -(arr[i] + arr[j]);
                if (s.contains(check)) {
                    l.add(arr[i]);
                    l.add(arr[j]);
                    l.add(check);
                    Collections.sort(l);
                    if (!list.contains(l))
                        list.add(l);
                }
                s.add(arr[j]);
            }
        }
        return list;
    }


    public static List<List<Integer>> triplet(int n, int[] arr) {
        // Write your code here.
        List<List<Integer>> list = new ArrayList<>();
        //   int n=arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(arr[i]);
                        l.add(arr[j]);
                        l.add(arr[k]);
                        Collections.sort(l);
                        if (!list.contains(l))
                            list.add(l);
                    }
                }
            }
        }
        return list;
    }
}

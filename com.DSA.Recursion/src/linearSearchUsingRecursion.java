import java.util.ArrayList;

public class linearSearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,8};
        System.out.println(FindAllElementsRetArrayList(arr, 4));
    }

    private static boolean isElementinArray(int[] arr, int element) {
        return isElementHelper(arr, element, 0);
    }

    private static boolean isElementHelper(int[] arr, int element, int s) {
        if (s == arr.length)
            return false;
        else
            return (arr[s] == element) || isElementHelper(arr, element, s + 1);
    }

    private static int FindIndexElementHelper(int[] arr, int element, int s) {
        if (s == arr.length)
            return -1;
        if (arr[s] == element)
            return s;
        else
            return FindIndexElementHelper(arr, element, s + 1);
    }

    private static ArrayList<Integer> FindAllIndexElementArrayList(int[] arr, int element) {
        int s = 0;
        ArrayList<Integer> list = new ArrayList<>();
        return FindAllIndexElementHelper(arr, element, s, list);
    }

    //{2,4,6,2,8,8,8,9}; element=3;
    private static ArrayList<Integer> FindAllIndexElementHelper(int[] arr, int element, int s, ArrayList<Integer> al) {
        if (s == arr.length)
            return al;
        if (arr[s] == element) {
            al.add(s);
        }
        return FindAllIndexElementHelper(arr, element, s + 1, al);
    }



    private static ArrayList<Integer> FindAllElementsRetArrayList(int[] arr, int element) {
        int s = 0;
        return FindAllElementsRetArrayListHelper(arr,element,s);
    }
    /*private static ArrayList<Integer> FindAllElementsRetArrayListHelper(int[] arr, int element, int s) {
        ArrayList<Integer> l = new ArrayList();
        if (s == arr.length)
            return l;
        if (arr[s] == element)
            l.add(s);
        l.addAll(FindAllElementsRetArrayListHelper(arr, element, s + 1));
        return l;
    }*/
    private static ArrayList<Integer> FindAllElementsRetArrayListHelper(int[] arr, int element, int s) {
        ArrayList<Integer> l = new ArrayList();
        if (s == arr.length)
            return l;
        if (arr[s] == element) {
            l.add(s);
        }
        ArrayList<Integer> ansFomBeloCalls = FindAllElementsRetArrayListHelper(arr, element, s + 1);
        l.addAll(ansFomBeloCalls);
        return l;
    }


}

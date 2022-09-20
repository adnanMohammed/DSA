import java.util.ArrayList;

public class ReverseElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //int[] newArray=reverseElements(arr);
        int[] newArr=reverseElementsAfterPos(arr,0);
        for(int i2:newArr){
            System.out.print(i2+" " );
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
       // reverseElementsAfterPosArrayList(al, 0);
    }

    public static void reverseElementsAfterPosArrayList(ArrayList<Integer> arr, int m) {
        int dec = arr.size() / 2 + m;
        int val = arr.size();
        for (int i = m + 1; i < dec; i++) {
            val = val - 1;
            arr.set(i, arr.get(i) + arr.get(val));
            arr.set(val, arr.get(i) - arr.get(val));
            arr.set(i, arr.get(i) - arr.get(val));
        }

        for (int im : arr) {
            System.out.print(im + " ");
        }

    }


    public static int[] reverseElementsAfterPos(int[] arr, int m) {
        int dec = arr.length / 2 + m;
        int val = arr.length;
        for (int i = m + 1; i < dec; i++) {
            val = val - 1;
            arr[i] = arr[i] + arr[val];
            arr[val] = arr[i] - arr[val];
            arr[i] = arr[i] - arr[val];

        }
        return arr;
    }

    private static int[] reverseElements(int[] arr) {
        int dec = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[i] + arr[dec - i];
            arr[dec - i] = arr[i] - arr[dec - i];
            arr[i] = arr[i] - arr[dec - i];
        }
        return arr;
    }
}

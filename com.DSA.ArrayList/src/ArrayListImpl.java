public class ArrayListImpl {
    int[] arr = new int[2];
    int size = 0;


    public void remove(int index) {
        if (index > size) {
            System.out.println("no value at index=" + index);
        } else {
            arr[index] = 0;
            for (int i = index + 1; i <= size; i++) {
                arr[index++] = arr[i];
            }
        }
    }

    public void add(int i) {
        if (size < arr.length) {
            arr[size] = i;
        } else {
            int add = 0;
            int[] arr1 = new int[2 * arr.length];
            for (int i2 : arr) {
                arr1[add++] = i2;
            }
            arr = arr1;
            arr[size] = i;
        }
        size = size + 1;

    }

    public int get(int index) {
        if (arr.length <= index) {
            throw new ArrayIndexOutOfBoundsException();
        } else
            return arr[index];
    }

    public int size() {
        return arr.length;
    }

    public void clear() {
        arr = new int[2];
        size = 0;
    }

    public boolean contains(int value) {
        for(int i=0;i<=size;i++){
            if(arr[i]==value)
                return true;
        }
        return false;
    }
}

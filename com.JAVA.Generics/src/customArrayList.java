
public class customArrayList<T> {
    Object[] arr;
    static int default_size = 5;
    int size = 0;

    public customArrayList() {
        this.arr = new Object[default_size];
    }

    public boolean add(T value) {
        if (size < default_size) {
            arr[size] = value;
            size += 1;
            return true;
        } else {
            default_size = default_size * 2;
            Object[] newArr = new Object[default_size];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
            arr[size] = value;
            size += 1;
            return true;

        }

    }

    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(value))
                return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else return false;
    }

    public Object get(int index) {
        if (index > size) {
            return -1;
        } else return arr[index];
    }


    public void clear() {
        default_size = 5;
        this.arr = new Object[default_size];
        int size = 0;
    }

    public int size() {
        return size;
    }

    public boolean remove(int index) {
        if(index>=size){
            return false;
        }
        arr[index] = 0;
        int i;
        for ( i = index; i < size-1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i]=null;
        return true;
    }

}

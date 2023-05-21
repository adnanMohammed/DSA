public class Human implements Cloneable{

    String name;
    int age;
    int[] arr;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.arr=new int[]{1,2,3,4,5};
    }

    public Human(Human humanBeing){
        this.name=humanBeing.name;
        this.age=humanBeing.age;
    }

    protected  Object clone() throws CloneNotSupportedException {
        Human h1 = (Human) super.clone();
        h1.arr = new int[h1.arr.length];
        for (int i = 0; i < h1.arr.length; i++) {
            h1.arr[i] = this.arr[i];
        }
        return h1;
    }
}

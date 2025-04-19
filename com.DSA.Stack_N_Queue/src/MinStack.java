import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    Stack<Integer> st=null;
    List<Integer> listMin=new ArrayList<>();
    public MinStack() {
        st=new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        listMin.add(val);
    }

    public void pop() {
        if (!st.isEmpty()){
            st.pop();
            listMin.remove(listMin.size()-1);
        }
    }

    public int top() {
       return st.peek();

    }

    public int getMin() {
        if (!listMin.isEmpty())
            return listMin.stream().mapToInt(i->i).min().getAsInt();

        return -1;
    }
}

class MinStackMain{
    public static void main(String[] args) {
        MinStack ms=new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        ms.getMin();
        ms.pop();
        ms.top();
        ms.getMin();


    }
}
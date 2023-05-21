public class CustomStackMain {
    public static void main(String[] args) throws Exception {
        CustomStackGeneric st1 = new CustomStackGeneric();
        st1.push("adnan");
        st1.push(1);
        st1.push(true);
        CustomStack st =new CustomStack();
     //   System.out.println(st.peek());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println( st.search(1));
        st.pop();
        System.out.println( st.search(1));
        System.out.println( st.peek());
        st.empty();
        System.out.println(st.search(51));

    }
}

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
    int open=0;StringBuilder temp= new StringBuilder();
    char[] ch=s.toCharArray();

        for (char c:ch) {
            if(c=='('){
                if(open>0)
                    temp.append(c);
                open++;
            }
            else if(c==')'){
                open--;
                if(open>0)
                    temp.append(c);
            }
        }
        return temp.toString();
    }
}


class RemoveOutermostParenthesesMain{
    public static void main(String[] args) {
        RemoveOutermostParentheses ro=new RemoveOutermostParentheses();
        String s="(()())(())";
        System.out.println(   ro.removeOuterParentheses(s));

    }
}
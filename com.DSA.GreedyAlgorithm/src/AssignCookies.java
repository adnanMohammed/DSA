import java.util.Arrays;

public class AssignCookies {
    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        //your code goes here
        Arrays.sort(Student);
        Arrays.sort(Cookie);

        int s1=0,c1=0;
        int count=0;

        while (s1<Student.length && c1<Cookie.length){
            if (Student[s1]<= Cookie[c1]){
                count++; s1++; c1++;
            }
            else s1++;
        }

        return count;
    }
}

class AssignCookiesMain{
    public static void main(String[] args) {
        AssignCookies a=new AssignCookies();
        int[] Student={4,5,1}; int[] Cookie={6,4,2};
        a.findMaximumCookieStudents(Student,Cookie);
    }
}

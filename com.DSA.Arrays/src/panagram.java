import java.util.ArrayList;
import java.util.List;

public class panagram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        checkIfPangram(sentence);
    }

    public static boolean checkIfPangram(String sentence) {
        char c = 'a';//97
        char c1 = 'z';//122
        int[] alp = new int[26];
        int index = 0;
        for (int i = 97; i <= 122; i++) {
            alp[index++] = i;
        }
        char[] ch = sentence.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int i1 = ch[i];
            alp[i1 - 97] = 0;
        }
        for (int cn : alp) {
            if (cn != 0)
                return false;
        }
        return true;

    }
}

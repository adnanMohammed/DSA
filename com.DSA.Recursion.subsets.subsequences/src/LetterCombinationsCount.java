public class LetterCombinationsCount {

    public static void main(String[] args) {
        System.out.println(LetterCombinationCount("", "23"));
    }

    public static int LetterCombinationCount(String proc, String unproc) {
        if (unproc.isEmpty()) {
           // System.out.print(proc + ",");
            return 1;
        }
        int digit = unproc.charAt(0) - 48;
        int range = 0;
        int count = 0;
        int rangeTill = 0;
        if (digit == 8 || digit == 9) {
            range = ((digit - 2) * 3) + 1;
        } else {
            range = (digit - 2) * 3;
        }
        if (digit == 7 || digit == 9) {
            rangeTill = range + 4;
        } else {
            rangeTill = range + 3;
        }

        for (int i = range; i < rangeTill; i++) {
            char ch = (char) (i + 97);
            count = count + LetterCombinationCount(proc + ch, unproc.substring(1));
        }
        return count;
    }

}

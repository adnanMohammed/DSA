public class CharacterHashing {

    public static void main(String[] args) {
        int i='a';
        System.out.println("a="+i);
        String str="abcdabefc";
        characterHashAppearance(str,'c');
    }

    public static void characterHashAppearance(String str,char appearanceChar){
        int[] ch=new int[26]; int addValue=97;
        for (int i = 0; i < str.length(); i++) {
            ch[str.charAt(i)-97]+=1;

        }
           char[] c1= str.toCharArray();
       for(int i:c1){
           char c=(char)(i);
           System.out.println(c+" appears="+ch[i-97]+" times");
       }

    }
}

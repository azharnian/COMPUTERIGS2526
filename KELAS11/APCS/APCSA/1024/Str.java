public class Str {

    public static void changeStr(String s){
        s = "Budi";
    }

    public static void main(String[] args){
        String s1 = "Anas";
        String s2 = s1;

        changeStr(s1);
        System.out.print(s1);
    }

}
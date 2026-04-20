import java.util.Scanner;
public class L601 {

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        String name = console.nextLine();
        printName(name);
        System.out.println(pigLatin("pig"));
    }

    public static void printName(String fullname)
    {
        // Michael Benjamin Smith
        int fS = fullname.indexOf(" ");
        String fName = fullname.substring(0, fS);

        System.out.println("First: " + fName);

        fullname = fullname.substring(fS+1);
    }

    public static String pigLatin(String word)
    {
        return word.substring(1) + word.substring(0, 1) + "ay";
    }

}
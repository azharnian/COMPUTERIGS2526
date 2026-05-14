import java.io.*;
import java.util.*;

public class Text{
    public static void main(String[] args)throws FileNotFoundException {
        File myText = new File("roster.txt");

        ArrayList<String> usernames = new ArrayList<String>();
        Scanner scan = new Scanner(myText);
        while(scan.hasNext()){
                String[] temp = scan.next().split("-");
                usernames.add(temp[1].substring(0, 1)+ temp[0]);
            }
        System.out.println(usernames);
    }
}
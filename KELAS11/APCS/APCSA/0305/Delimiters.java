import java.util.*;

public class Delimiters{
    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close){
        openDel = open;
        closeDel = close;
    }

    public ArrayList<String> getDelimiters(String[] tokens){
        ArrayList<String> ans = new ArrayList<String>();
        for (String token : tokens){
            if (token.equals(openDel)) ans.add(token);
            else if (token.equals(closeDel)) ans.add(token);
        }
        return ans;
    }

    public boolean isBalanced(ArrayList<String> tokens){
        int numOpen = 0;
        for (String token : tokens){
            if (token.equals(closeDel) && numOpen == 0) return false;

            if (token.equals(openDel)) numOpen++;
            else if (token.equals(closeDel)) numOpen--;
        }
        if (numOpen == 0) return true;
        return false;
    }

    public static void main(String[] args){
        Delimiters d = new Delimiters("<sup>", "</sup>");
        String[] tokens = {"<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>"};
        ArrayList<String> tokensArr = new ArrayList<String>(Arrays.asList(tokens));
        System.out.println(d.getDelimiters(tokens));
        System.out.println(d.isBalanced(tokensArr));
    }
}
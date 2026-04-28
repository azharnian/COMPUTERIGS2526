public class FRQ2302{

}

class Sign{
    private String line;
    private int numLines;
    
    public Sign(String line, int numLines){
        this.line = line;
        this.numLines = numLines;
    }

    public int numberOfLines(){
        if (line.length() % numLines == 0){
            return line.length()/numLines;
        } else{
            return line.length()/numLines + 1;
        }
    }

    public String getLines(){
        String temp = line;
        String ans = "";
        while (temp.length() > 0){
            ans += temp.substring(0, numLines) + ";";
            temp = temp.substring(numLines);
        }
        return ans.substring(0,ans.length()-1);
    }
}
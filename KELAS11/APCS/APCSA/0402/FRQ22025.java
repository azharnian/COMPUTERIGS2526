public class FRQ22025{

}

class SignedText{
    String first;
    String last;

    public SignedText(String f, String l){
        first = f;
        last = l;
    }

    public String getSignature(){
        if (first.equals("")) return last;
        return first.subString(0, 1) + "-" + last;
    }

    public String addSignature(String text){
        
    }
}
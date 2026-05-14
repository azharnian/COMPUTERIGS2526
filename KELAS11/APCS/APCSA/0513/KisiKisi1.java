public class KisiKisi{

}

class MessageBuilder{
    private String message;
    private int numWords;

    public MessageBuilder(String startingWord){
        String res = startingWord;
        String temp = getNextWord(startingWord);
        int counter = 1;
        while(temp){
            res += " " + temp;
            counter++;
            temp = getNextWord(temp);
        }
        message = res;
        numWords = counter;
    }

    public String getNextWord(String word){
        // not shown
    }

    public String getAbbrivation(){
        String[] words = message.split(" ");
        String res = "";
        for (int i = 0; i < words.length; i++){
            res += words[i].substring(0,1);
        }
        return res;
    }
}
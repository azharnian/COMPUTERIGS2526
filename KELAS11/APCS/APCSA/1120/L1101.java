public class L1101 {

    public static void main(String[] args){
        printTwoDigit(4);
        printTwoDigit(7);
    }

    public static int random(int start, int end){
        return (int) Math.floor(Math.random() * (end-start+1) + start );
    }

    public static void printTwoDigit(int n){
        boolean was13Seen = false;
        int randomNumber;
        for (int i = 0; i < n; i++){
            randomNumber = random(10, 99);
            System.out.println("next = " + randomNumber);
            if (randomNumber == 13) was13Seen = true;
        }
        if (was13Seen)
            System.out.println("we saw a 13!");
        else
            System.out.println("no 13 was seen.");
    }
}
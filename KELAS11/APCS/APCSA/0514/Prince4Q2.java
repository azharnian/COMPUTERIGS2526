public class Prince4Q2{

}

class Deck{
    private int[] cards;

    public boolean inOrder(){
        for (int k = 0; k < cards.length; k++){
            if (cards[k] != k) return false;
        }
        return true;
    }

    public void shuffle(){
        int[] temp = new int[cards.length];

        int mid = cards.length/2;

        for (int i = 0; i < mid; i++){
            temp[2*i] = cards[i];
            temp[2*i + 1] = cards[mid + i];
        }

        cards = temp;
    }

    public int reorderCount(){
        int counter = 0;
        while(!inOrder){
            shuffle();
            counter++;
        }
        return counter;
    }
}
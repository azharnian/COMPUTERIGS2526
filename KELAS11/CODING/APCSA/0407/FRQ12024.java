public class FRQ12024{

}

class Feeder{
    
    private int currentFood;

    public void simulateOneDay(int numBirds){
        int percentage = (int) Math.floor(Math.random() * 100);
        if (percentage <= 94) {
            int food = (int) Math.floor(Math.random() * 40) + 10;
            currentFood -= (food * numBirds);
            if (currentFood < 0) {
                currentFood = 0;
            }
        } else {
            currentFood = 0;
        }
    }
}
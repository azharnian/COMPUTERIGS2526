public class Sprite {
    double x;
    double y;
    String name;

    Sprite(double xVal, double yVal){
        x = xVal;
        y = yVal;
    }

    public static void main(String[] args){
        Sprite player1 = new Sprite(10, 10);
        Sprite player2 = new Sprite(0, 0);
    }
}
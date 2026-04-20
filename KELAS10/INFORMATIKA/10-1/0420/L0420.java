public class L0402{
    public static void main(String[] args){
        Sprite player1 = new Sprite(10, 10);
        Sprite player2 = new Sprite(0, 0);
        System.out.println("Position P1 : " + player1.x + ", " + player1.y);
        System.out.println("Position P2 : " + player2.x + ", " + player2.y);

        Sprite player3 = new Sprite("Harry", 100, 100);
        System.out.println("Name P3 : " + player3.name);
        System.out.println("Name P1 : " + player1.name);
        System.out.println("Name P2 : " + player2.name);
    }
}

class Sprite{
    double x; // 0.0
    double y; // 0.0
    String name; // null

    Sprite(double xVal, double yVal){
        x = xVal;
        y = yVal;
    }

    Sprite(String n, double xVal, double yVal){
        name = n;
        x = xVal;
        y = yVal;
    }
}
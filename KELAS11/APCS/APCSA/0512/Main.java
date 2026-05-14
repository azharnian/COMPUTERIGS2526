public class Main{
    public static void main(String[] args){
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);

        System.out.println(p1.isEquiv(p2));
    }
}

class Point{
    private int xCoor;
    private int yCoor;

    public Point(int x, int y){
        xCoor = x;
        yCoor = y;
    }

    public int getXCoor(){
        return xCoor;
    }

    public int getYCoor(){
        return yCoor;
    }

    public boolean isEquiv(Point otherP){
        return otherP.xCoor == x && otherP.yCoor == y;
    }
}
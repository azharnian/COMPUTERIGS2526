public class Lab1301 {

    public static void main(String[] args){
        Circle c = new Circle(10);

        System.out.println(c.getArea());
        System.out.println(c.isInCircle(10, 30));
        c.translate(10, 10);
        c.tripleTheRadius();
    }

}

class Circle {
    private int x;
    private int y;
    private double radius;

    public Circle(double r){
        x = 0;
        y = 0;
        radius = r;
    }

    public Circle(int pointX, int pointY, double r){
        x = pointX;
        y = pointY;
        radius = r;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public boolean isInCircle(int a, int b){
        return (a-x)*(a-x) + (b-y)*(b-y) < radius*radius;
    }

    public void translate(int dx, int dy){
        x += dx;
        y += dy;
    }

    public void tripleTheRadius(){
        radius *= 3;
    }
}
public class Q19
{
    public static void main(String[] args)
    {
        MyRectangle rect = new MyRectangle(2, 3);
        System.out.print(rect.getPerimeter());
    }
}

class MyRectangle
{
    private int width;
    private int height;
    private int perimeter;

    MyRectangle(int w, int h)
    {
        width = w;
        height = h;
        int perimeter = 2 * (width + height);
    }

    public double getPerimeter()
    {
        return perimeter;
    }
}
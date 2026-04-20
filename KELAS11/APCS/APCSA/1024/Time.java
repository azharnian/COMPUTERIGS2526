public class Time {
    private int hrs, mins, secs;

    Time (int h, int m, int s)
    {
        Time t = new Time(h, m, s);
    }

    public static void main(String[] args)
    {
        Time t = new Time(10, 5, 3);
    }
}
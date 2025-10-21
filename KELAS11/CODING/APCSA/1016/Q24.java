public class Q24{
    public static void main(String[] args)
    {
        System.out.println(reverse(234));
    }

    public static int reverse(int n)
    {
        int rem, revNum=0;
        for (int i = 0; i <= n; i++)
        {
            rem = n%10;
            revNum = revNum * 10 + rem;
            n /= 10;
        }
        return revNum;
    }
}
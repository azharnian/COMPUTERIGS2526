public class Q12 {
    public static void main(String[] args)
    {
        int count = 0;
        String star ="*";
        for (int i = 1; i < 11; i++)
            for (int j = 10; j > 1; j -=2)
            {
                star += "**";
                count++;
            }
        System.out.println("\n"+ count + " " + star.length());
        // i = 1, j = 10, star = 3, count = 1
        // i = 1, j = 8, star = 5, count = 2
        // i = 1, j = 6, star = 7, count = 3
        // i = 1, j = 4, star = 9, count = 4
        // i = i, j = 2, star = 11, count = 5
        // i = 1, j = 0 (x)
        // ...
        // i = 10, j, star = 1 + 10(10), count = 0 + 10(5)
        // count = 50, star = 101

    }
}
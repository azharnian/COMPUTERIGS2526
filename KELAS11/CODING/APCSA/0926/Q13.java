public class Q13 {
    public static void main(String[] args)
    {
        for (int i = 1; i <= 5; i++) // baris - row
        {
            for (int j = 1; j < i; j++) // kolom - column
            {
                System.out.println("- ");
            }
            for (int j = i; j <= 5; j++)
            {
                System.out.println("* ");
            }
            System.out.println();
        }
        // i = 1 , j 1 < 1 (x -) ==> * * * * *
        // i = 2, j 1 < 2,       ==> - * * * * (B)x
    }
}
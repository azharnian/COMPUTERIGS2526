import java.util.Scanner;

public class L031 {
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int a1, a2, a3;

        System.out.print("Enter grade: ");
        a1 = console.nextInt();

        System.out.print("Enter grade: ");
        a2 = console.nextInt();

        System.out.print("Enter grade: ");
        a3 = console.nextInt();

        double ave = (a1 + a2 + a3) / 3.0;
        double variance = ( Math.pow((a1-ave), 2) + Math.pow((a2-ave), 2) + Math.pow((a3-ave), 2) ) / 3.0;
        double stdv = Math.sqrt(variance);
    }
}
import java.util.Scanner;

public class Lab1{
    public static void main(String[] args){
        int a1, a2, a3;
        double ave, variance, stdv;

        Scanner console = new Scanner(System.in);

        System.out.print("Enter grade : ");
        a1 = console.nextInt();

        System.out.print("Enter grade : ");
        a2 = console.nextInt();

        System.out.print("Enter grade : ");
        a3 = console.nextInt();

        ave = (a1 + a2 + a3) / 3.0;
        variance = ( Math.pow(a1 - ave, 2) +  Math.pow(a2 - ave, 2) + Math.pow(a3 - ave, 2) )/ 3.0;
        stdv = Math.sqrt(variance);

        System.out.println("Average : " + ave);
        System.out.println("Variance : " + variance );
        System.out.println("Standard Deviation : " + stdv);
    }
}
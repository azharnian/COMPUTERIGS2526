import java.util.Scanner;

public class L022 {

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int pens, pencils;

        System.out.print("Enter the number of pens: ");
        pens = console.nextInt();

        System.out.print("Enter the number of pencils: ");
        pencils = console.nextInt();

        System.out.println("Total is " + (pens + pencils) + " pens and pencils.");


    }

}
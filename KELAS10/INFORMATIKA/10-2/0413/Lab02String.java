import java.util.Scanner;

public class Lab02String{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int pens, pencils, total;

        System.out.print("Enter the number of pens: ");
        pens = console.nextInt();

        System.out.print("Enter the number of pencils: ");
        pencils = console.nextInt();

        total = pens + pencils;

        System.out.println("Total is " + total + " pens and pencils.");

    }
}
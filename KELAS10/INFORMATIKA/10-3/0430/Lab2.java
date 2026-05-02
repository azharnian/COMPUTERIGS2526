import java.util.Scanner;

public class Lab2{
    public static void main(String[] args){
        int cents, quarter, dime, nickel, penny;
        Scanner console = new Scanner(System.in);

        System.out.print("Enter your cents : ");
        cents = console.nextInt();

        quarter = cents / 25;
        cents %= 25;

        dime = cents / 10;
        cents %= 10;

        nickel = cents / 5;
        cents %= 5;

        penny = cents;

        System.out.println(quarter + " quarters," + 
                            dime + " dimes," +
                            nickel + " nickels," +
                            penny + " pennies." );
    }
}
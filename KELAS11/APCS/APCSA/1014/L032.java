import java.util.Scanner;
public class L032 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int totalCents = console.nextInt();
        int quarters, dimes, nickels, pennies;

        quarters = totalCents / 25;
        totalCents %= 25;

        dimes = totalCents / 10;
        totalCents %= 10;

        nickels = totalCents / 5;
        totalCents %= 5;

        pennies = totalCents;

        

    }
}
import java.util.*;

public class Lab2{
    public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    System.out.print("Enter total cents : ");
    int totalCents = console.nextInt();
    int quarters, dimes, nickels, pennies;

    quarters = totalCents / 25;
    totalCents %= 25;

    dimes = totalCents / 10;
    totalCents %= 10;

    nickels = totalCents / 5;
    totalCents %= 5;

    pennies = totalCents;

    // 5 quarters, 1 dimes, 0 nickels, 2 pennies. 
    System.out.print(quarters + " quarters, ");
    System.out.print(dimes + " dimes, ");
    System.out.println(nickels + " nickels, " + pennies + " pennies.");
    }
}
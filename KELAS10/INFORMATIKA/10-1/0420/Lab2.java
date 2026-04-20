import java.util.Scanner;

public class Lab2{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        int money, quarter, dime, nickle, penny;

        System.out.print("Enter the changes : ");
        money = console.nextInt();

        quarter = money / 25;
        money %= 25;

        dime = money / 10;
        money %= 10;

        nickle = money / 5;
        money %= 5;

        penny = money;

        System.out.print("Quarters : " + quarter);
        System.out.print(" Dimes : " + dime);
        System.out.print(" Nickles : " + nickle);
        System.out.println(" Pennies : " + penny);
    }
}
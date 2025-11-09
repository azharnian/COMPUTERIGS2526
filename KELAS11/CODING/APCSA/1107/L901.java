import java.util.Scanner;

public class L901{

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.print("Height (in cm): ");
        double height = console.nextDouble();
        // dst...
        System.out.println("BMI = " + bmi(height, weight));
        System.out.println(weight(height, weight));

        console.close();
    }

    public static double bmi(double height, double weight){

        return 0.0;
    }

    public static String weightClass(double height, double weight){
        double value = bmi(height, weight);

        return "";
    }
}
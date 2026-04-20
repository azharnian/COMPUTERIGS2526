import java.util.Scanner;

public class Main{

    public static int getDiv(int a, int b){
        return a / b;
    }

    public static int recursive(int a,int b){
        if (a == 0 || b == 0){
            return 1;
        } 
        return (a-b) + recursive(a, b-1) + recursive(a-1, b);
    }

    public static void main(String[] args){
       

    }

}
import java.util.*;

public class ExScanner 
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.print("Who are you ? ");
        String name = console.nextLine();

        System.out.println("Nice to meet you "+ name);
    }
}
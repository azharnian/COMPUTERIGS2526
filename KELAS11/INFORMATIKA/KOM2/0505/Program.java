public class Program {
    public static void main(String[] args){
        if (args.length > 0)
            for (String item : args){
                if (item.equals("-c"))
                    System.out.println("Copy Mode");
                else if (item.equals("-q"))
                    System.out.println("Quit Mode");
                else
                    System.out.println("Undefined Command.");
            }
        else
            System.out.println("No args detected.");
    }
}
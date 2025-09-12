public class Q8{

    public static void main(String[] args)
    {
        String name1 = new String("Anas");
        String name2 = "Anas";

        System.out.println(name1.equals(name2));
        System.out.println(name1.equalsIgnoreCase(name2));
        System.out.println(name1 == name2);
    }
}
public class Q6 {

    public static void main(String[] args)
    {
        String str = new String("superstar");

        System.out.print(str.substring(1, 3) + " ");
        str.substring(1); // useless
        System.out.print(str.substring(1, 3) + " ");
        str.substring(1);
        System.out.print(str.substring(1, 3) + " ");
        str.substring(1);
    }

}
public class Q7 {
    public static void main(String[] args)
    {
        boolean isBlack;

        // I
        isBlack = true;
        isBlack = !isBlack;
        System.out.println(isBlack); // false
        isBlack = !isBlack;
        System.out.println(isBlack); // true

        // II
        isBlack = true;
        if (!isBlack) isBlack = true;
        else isBlack = false;
        System.out.println(isBlack); // false
        if (!isBlack) isBlack = true;
        else isBlack = false;
        System.out.println(isBlack); // true

        // III
        isBlack = true;
        if (isBlack) isBlack = false;
        System.out.println(isBlack); // false
        if (isBlack) isBlack = false;
        System.out.println(isBlack); // true

    }
}
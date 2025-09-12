import java.util.*;

public class Q5 {

    public static void main(String[] args)
    {
        // ArrayList<Integer> numbers = new ArrayList<Integer>();
        // numbers.add(1);
        // numbers.add(2);

        // System.out.println(numbers);
        // System.out.println(numbers.get(0));

        ArrayList<SalesRep> list1 = new ArrayList<SalesRep>();

        list1.add(new SalesRep(1, "Anas", 1000));
        list1.add(new SalesRep(2, "Budi", 2000));
        list1.add(new SalesRep(3, "Cindy", 3000));

        double sum = 0;
        for (SalesRep r : list1)
        {
            sum += r.getYtdSales();
        }

        System.out.println(sum);

        double sum2 = 0;
        for (int i = 0; i < list1.size(); i++)
        {
            sum2 += list1.get(i).getYtdSales();
        }

        System.out.println(sum2);

    }

}

class SalesRep {
    private int idNum;
    private String Name;
    private int ytdSales;

    // Constructor
    SalesRep(int i, String n, int ytd)
    {
        idNum = i;
        Name = n;
        ytdSales = ytd;
    }

    public int getYtdSales() {return ytdSales;}
}
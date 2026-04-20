public class Q4 {
    public static void main(String[] args)
    {
        SalesRep sales = new SalesRep(10, "John", 1000);
        Student student = new Student("Anas");
        Student student_2 = new Student("Anas");

        System.out.println(Student.getNumStudents());
        
        System.out.println(student.name);
        // System.out.println(sales.Name);

        double bonus = computeBonus(sales, 0.1);
        System.out.println(bonus);

        double bonusPoint = computePointBonus(student, 0.4);
        System.out.println(bonusPoint);

    }

    public static double computeBonus(SalesRep s, double percentage)
    {
        return s.getYtdSales() * percentage;
    }

    public static double computePointBonus(Student s, double percentage)
    {
        return s.point * percentage;
    }
}

public class SalesRep {
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

public class Student {
    private static int numStudents = 0;

    public String name;
    public double point;

    Student(String n)
    {
        name = n;
        point = 100;
        numStudents += 1;
    }

    public static int getNumStudents()
    {
        return numStudents;
    }

}
public class Q1 {
    public static void main(String[] args){
        StudentRecord a = new StudentRecord();
        a.updateGPA(3.5);
        System.out.println(a);

        System.out.println(StudentRecord.getNumsSR());
    }
}

class StudentRecord{
    public String name;
    private int ID;
    private double gpa;

    public static int numsSR = 0;

    StudentRecord(){
        this("Budi Santoso", 0.0);
    }

    StudentRecord(String name, double gpa){
        this.name = name;
        this.gpa = gpa;

        numsSR++;
        this.ID = numsSR;
    }

    public String toString(){
        return "ID : " + this.ID + " Student name : " + this.name + " and GPA : " + this.gpa;
    }

    public void updateGPA(double newGPA){
        if (newGPA <= 4.0)
            this.gpa = newGPA;
    }

    public void increaseGPA(double amount){
        double gpa = this.gpa + amount;
        if (gpa <= 4.0)
            this.gpa = gpa;
        
    }

    public static int getNumsSR(){
        return numsSR;
    }
}
public class Main{
    public static void main(String[] args){
        StudentRecord s1 = new StudentRecord();
        StudentRecord s2 = new StudentRecord("john", 123, 3.0);

        System.out.println(s1); // Jane
        System.out.println(s2); // john

        // Student.sayHi();

        // Student s1 = new Student();
        // s1.sayMyName();
    }
}

class StudentRecord{
    public String name;
    private int studentId;
    private double gpa;

    public static int numStudRec = 0;

    public StudentRecord(){
        numStudRec++;
        studentId = numStudRec;
        name = "Jane";
        gpa = 0.0;
    }

    public StudentRecord(String name, int studentId, double gpa){
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;

        numStudRec++;
    }

    public String toString(){
        return this.name + " , GPA : " + this.gpa;
    }

    public void updateGPA(double newGPA){
        this.gpa = newGPA;
    }

    public void increaseGPA(double amount){
        double gpa = this.gpa + amount;
        if (gpa <= 4.0)
            this.updateGPA(gpa);
    }
}

class Student{

    String name;

    Student(){
        name = "John";
    }

    public static void sayHi(){
        System.out.println("Hi...");
    }

    public void sayMyName(){
        System.out.println("Hi my name is "+ name);
    }
}
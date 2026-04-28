public class StudentRecord{

    public String name;
    private int id;
    private double gpa;

    public static int counter = 0;

    public StudentRecord(){
        this("John Doe", 0.0);
    }

    public StudentRecord(String name, double gpa){
        this.name = name;
        this.gpa = gpa;

        counter++;
        this.id = counter;
    }

    public String toString(){
        return "Student name is " + this.name + ", and gpa : " + this.gpa;
    }

    public void updateGPA(double newGPA){
        this.gpa = newGPA;
    }

    public void increaseGPA(double amount){
        double gpa = this.gpa + amount;
        if (gpa <= 4.0){
            this.gpa = gpa;
        }
    }

    public static int getNumsOfSR(){
        return counter;
    }

    public static void main(String[] args){
        StudentRecord s1 = new StudentRecord();
        StudentRecord s2 = new StudentRecord("Maria", 4.0);

        s2.updateGPA(2.0);
        s2.increaseGPA(1);
        System.out.println(s2);
        System.out.println("Numbers of Student Record is "+ StudentRecord.getNumsOfSR());
    }
}
public class Q01{
    public static void main(String[] args){
        StudentRecord s = new StudentRecord("Andy");
        s.updateGPA(3.5);
        s.increaseGPA(1);
        System.out.println(s);
        System.out.println(StudentRecord.getNumOfStudents());
    }
}

class StudentRecord {
    public String name;
    private int id;
    private double gpa;

    public static int numOfStudent = 0;

    public StudentRecord(){
        this("John Doe");
    }

    public StudentRecord(String name){
        this.name = name;
        this.gpa = 0.0;

        numOfStudent++;
        this.id = numOfStudent;
    }

    @Override
    public String toString(){
        return this.name + ", GPA: " + this.gpa;
    }

    public void updateGPA(double newGPA){
        this.gpa = newGPA;
    }

    public void increaseGPA(double amount){
        double incGPA = this.gpa + amount;
        if (incGPA <= 4.0){
            this.gpa = incGPA;
        }
    }

    public static int getNumOfStudents(){
        return numOfStudent;
    }
}
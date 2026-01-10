public class StudentRecord {
    public String name;
    private int ID;
    private double GPA;

    public static int numStudents = 0;

    StudentRecord(){
        this("budi", 0);
    }

    StudentRecord(String name, double GPA){
        this.name = name;
        this.GPA = GPA;

        numStudents++;

        this.ID = numStudents;
    }

    @Override
    public String toString(){
        return "Name : "+this.name+" GPA : "+this.GPA;
    }

    public static void main(String[] args){
        StudentRecord a = new StudentRecord();
        System.out.println(a);
    }
}
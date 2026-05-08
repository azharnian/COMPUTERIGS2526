public class Latihan01{
    public static void main(String[] args){
        Student s1 = new Student("Billy", 13);
        Student s2 = new Student("Clara", 14);
        Student s3 = new Student("Dean", 14);

        s1.sayHi();
        s2.sayHi();
        Student.saySchool();
        System.out.println(Student.counter);
    }
}

class Student{
    public String name;
    public int age;

    public static int counter = 0;
    public static final String school = "SMA IGS";

    public Student(String n, int a){
        name = n;
        age = a;
        counter++;
    }
    public void sayHi(){
        System.out.println("Hi, my name is "+ name);
    }
    public static void saySchool(){
        System.out.println("SMA IGS!!!");
    }
}
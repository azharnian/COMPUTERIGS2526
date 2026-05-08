public class Student{
    public String name;
    public int age;

    public Student(String n, int a){
        name = n;
        age = a;
    }

    public void sayHi(){
        System.out.println("Hi, my name is "+ name);
    }

    public static void saySchool(){
        System.out.println("SMA IGS!!!");
    }

    public static void main(String[] args){
        Student s1 = new Student("Billy", 13);
        Student s2 = new Student("Clara", 14);

        s1.sayHi();
        s2.sayHi();
        saySchool();
    }
}
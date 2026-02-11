import java.util.*;

public class Main {
    public static void main(String[] args){
        Employee e = new Employee("Budi", 10);
        // System.out.println(e.getVacationForm());

        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Employee("Cindy", 20));
        people.add(new Person()); 
    }
}
class Person{
   private String name;

   public Person(){
        name = "John";
   };

   public Person(String name){
    this.name = name;
   }

   public String toString(){
        return "Hi "+ name;
   }

   public String getVacationForm(){
    return "Black";
   }
}
class Employee extends Person{
   private int id;
   public Employee(String name, int id){
      //super(name); // Constructor Person Available
      this.id = id;
   }

    @Override
   public String getVacationForm(){
    return "Red";
   }
}

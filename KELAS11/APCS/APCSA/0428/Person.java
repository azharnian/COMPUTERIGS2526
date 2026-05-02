public class Person{
    private String name;

    public Person(){
        this.name = "John";
    }

    public Person(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }

    public static void main(String[] args){
        Employee emp = new Employee();
        // emp.setName();
        System.out.println(emp.getName());
    }
}

class Employee extends Person{
    private String name;
    private int id;

    public Employee(){
        super();
    }

    public void setName(){
        name = "Sushi";
    }

}

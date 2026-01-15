public class Main{

    public static void main(String[] args){
       Company c = new Company();
       
       System.out.println(c.averageSalary());

       Employee[] employees = {
            new Employee("Budi", 5000),
            new Employee("Cindy", 10000),
            new Employee("Dody", 20000)
        };
        System.out.println(Company.averageSalary(employees));
    }
}

class Employee{
    private String name;
    private double salary;

    Employee(String n, double s){
        name = n;
        salary = s;
    }

    public double getSalary(){return salary;}

    public String getName(){return name;}
}

class Company{
    private Employee[] employees = {
            new Employee("Budi", 1000),
            new Employee("Cindy", 2000),
            new Employee("Dody", 3000)
        };

    public double averageSalary(){
        double sum = 0.0;
        // for (Employee e: employees){
        //     sum += e.getSalary();
        // }

        for (int i=0; i < employees.length; i++){
            sum += employees[i].getSalary();
        }

        return sum/employees.length;
    }

    public static double averageSalary(Employee[] emps){
        double sum = 0.0;
        for (Employee e: emps){
            sum += e.getSalary();
        }

        return sum/emps.length;
    }

}
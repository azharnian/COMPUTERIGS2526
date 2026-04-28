public class EmployeeSalary{
    public String name;
    private int id;
    private double salary;

    public static int counter = 0;

    EmployeeSalary(){
        this("John", 0.0);
    }

    EmployeeSalary(String name, double salary){
        this.name = name;
        this.salary = salary;

        counter++;
        id = counter;
    }

    @Override
    public String toString(){
        return "Name is " + this.name + ", my salary is " + this.salary;
    }

    public void raiseSalary(double amount){
        salary += amount;
    }

    public void deductSalary(double amount){
        if (salary - amount > 0){
            salary -= amount;
        }
    }

    public static int getNumsEmp(){
        return counter;
    }

    public static void main(String[] args){
        EmployeeSalary emp1 = new EmployeeSalary();
        EmployeeSalary emp2 = new EmployeeSalary("Jane", 50000);

        emp2.raiseSalary(2000);
        System.out.println(emp2);
        emp2.deductSalary(100000);
        System.out.println(emp2);
        System.out.println(getNumsEmp()); // 2
    }
}
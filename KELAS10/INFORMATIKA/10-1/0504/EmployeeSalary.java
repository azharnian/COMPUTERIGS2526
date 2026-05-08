public class EmployeeSalary{
    public String name;
    private int id;
    private double salary;

    public static int counter = 0;

    public EmployeeSalary(String n, double s){
        name = n;
        salary = s;

        counter++;
        id  = counter;
    }

    public void raiseSalary(double amount){
        salary += amount;
    }

    public void deductSalary(double amount){
        if (salary - amount >= 0){
            salary -= amount;
        }
    }

    public static int getNumberOfEmp(){
        return counter;
    }

    public double getSalary(){
        return salary;
    }

    public static void main(String[] args){
        EmployeeSalary emp = new EmployeeSalary("Budi", 5000);
        emp.raiseSalary(2000);
        emp.deductSalary(500);
        System.out.println(emp.getSalary());
    }
}
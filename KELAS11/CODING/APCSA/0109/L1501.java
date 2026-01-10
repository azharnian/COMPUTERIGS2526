public class L1501{
    public static void main(String[] args){
        BankAccount user1 = new BankAccount("Danil", 50000);
        BankAccount user2 = new BankAccount("Anderson", 60000);
        user1.Withdraw(20000);
        user2.Deposit(20000);
        System.out.println(user1.toString());
        System.out.println(user2.toString());
    }
}

class BankAccount {
    public String name;
    private int accountNumber;
    private double balance;
    public static int numAccount = 0;

    BankAccount(){
        this("Jhondoe", 0);
    }

    BankAccount(String name, double balance){
        this.name = name;
        this.balance = balance;
        numAccount++;
        this.accountNumber = numAccount;
    }

    public String toString(){
        return "ID : " + accountNumber + " Name : " + name + " Balance : " + balance;
    }

    public void Withdraw(double n){
        if(this.balance >= n){
            this.balance -= n;
        }
    }

    public void Deposit(double n){
        this.balance += n;
    }

    public static int NumberAccount(){
        return numAccount;
    }
}


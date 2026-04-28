public class Q04{
    public static void main(String[] args){
        SmartBankAccount person1 = new SmartBankAccount();
        SmartBankAccount person2 = new SmartBankAccount("Jane", 100000);

        person2.deposit(50000); // 150000
        person2.withdraw(200000); // failed
        person2.withdraw(20000); // 130000
        System.out.println(person2.getTransactionHistory()); // Mutasi
        System.out.println(person2.getBalance()); // 130000
        System.out.println(SmartBankAccount.getAccountCount()); // 2
    }
}

class SmartBankAccount{
    public String name;
    private String accountNumber;
    private double balance;
    private String[] history = new String[10];
    private int counter;

    public static int numsAccount = 0;
    public static final double MIN_BALANCE = 100.0;


    public SmartBankAccount(){
        this("Unknown", MIN_BALANCE);
    }

    public SmartBankAccount(String n, double b){
        name = n;
        balance = b;
        numsAccount++;

        if (n.equals("Unknown")){
            accountNumber = "000000";
        } else {
            accountNumber = String.format("%06d", numsAccount);
        }
        history[counter] = "Account created";
        counter++;
    }

    public boolean deposit(double amount){
        if (amount > 0){
            balance += amount;
            history[counter] = "Deposit: " + amount;
            counter++;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        if (amount > 0 && balance - amount >= MIN_BALANCE){
            balance -= amount;
            history[counter] = "Withdraw: " + amount;
            counter++;
            return true;
        }
        history[counter] = "Withdraw failed";
        counter++;
        return false;
    }

    public double getBalance(){
        return balance;
    }

    public String getTransactionHistory(){
        String res = "";
        for (int i = 0; i < counter; i++){
            res += history[i] + "\n";
        }
        return res;
    }

    public static int getAccountCount(){
        return numsAccount;
    }
}
public class Q04{
    public static void main(String[] args){
        SmartBankAccount acc1 = new SmartBankAccount();
        SmartBankAccount acc2 = new SmartBankAccount("Jane");
    }
}

class SmartBankAccount{
    public String name;
    private String accNumber;
    private double balance;
    private String[] histories;
    private int transactionCounter = 0;

    private static int counter = 0;
    private static final double MIN_BALANCE = 100.0;


    public SmartBankAccount(){
        this("Unknown");
    }

    public SmartBankAccount(String n){
        name = n;

        counter++;
        if (n.equals("Unknown")) accNumber = "000000";
        else accNumber = String.format("%06d", counter);

        balance = MIN_BALANCE;

        histories = new String[10];
        histories[0] = "Account Created";
        transactionCounter++;

    }

    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
            histories[transactionCounter] = "Deposit: " + amount;
            transactionCounter++;
        }

    }

    public boolean withdraw(double amount){
        if (amount > 0 && (balance - amount >= MIN_BALANCE)){
            balance -= amount;

            histories[transactionCounter] = "Withdraw: " + amount;
            transactionCounter++;
            return true;
        }
        histories[transactionCounter] = "Withdraw failed";
        transactionCounter++;
        return false;
    }
}
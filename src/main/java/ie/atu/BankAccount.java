package ie.atu;


public class BankAccount {

    private String accNo;
    private String name;
    int balance;


    public BankAccount(String accNo, String name, int balance) {
        if(balance <= 0)
            throw new IllegalArgumentException("Balance must be greater than 0.");
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public BankAccount() {

    }

    public String getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void deposit(int amount) {
        balance += amount;
    }
}


package bank;

public class Account {
    int accountNumber;
    float balance;
    public void deposit(float value) {
        this.balance += value;
    }

    public void withdrawal(float value) {
        this.balance -= value;
    }

    public float getBalance() {
        return this.balance;
    }

    public void displayBalance() {
        System.out.println(this.balance);
    }

    public void transfer(float value, Account receiverAccount) {
        this.balance -= value;
        receiverAccount.balance += value;
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}

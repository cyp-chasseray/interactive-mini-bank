package bank;

public class Client {
    String name;
    Account[] accounts = new Account[100];
    int numberOfAccounts;
    public String getName() {
        return this.name;
    }

    public float getBalance(Account accountToStudy) {
        return accountToStudy.balance;
    }

    public void displayBalance(Account accountToStudy) {
        System.out.println(this.getBalance(accountToStudy));
    }
    public float getTotalBalance() {
        float totalBalance = 0;
        for (int i=0; i<this.numberOfAccounts; i++) {
            totalBalance += accounts[i].balance;
        }
        return totalBalance;
    }

    public Account[] getAccounts() {
        return this.accounts;
    }

    public void displayTotalBalance() {
        System.out.println(this.getTotalBalance());
    }

    public void addAccount(Account newAccount) {
        this.numberOfAccounts += 1;
        accounts[numberOfAccounts-1] = newAccount;
    }

    public void bailout() {
        for (int i=0; i<this.numberOfAccounts; i++) {
            if (this.accounts[i].balance<0) {
                float amountToBail = this.accounts[i].balance *(-1);
                for (int j=0; j<this.numberOfAccounts; j++) {
                    if (this.accounts[j].balance>amountToBail) {
                        this.accounts[j].transfer(amountToBail, this.accounts[i]);
                    }
                }
            }
        }
    }

    public Client (String nomDuClient) {
        this.name = nomDuClient;
    }

}

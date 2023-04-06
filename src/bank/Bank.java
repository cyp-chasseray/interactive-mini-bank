package bank;

public class Bank {
    String name;
    Client[] clients = new Client[100];
    int numberOfClients;

    public void addClient(Client newClient) {
        this.numberOfClients +=1;
        clients[numberOfClients-1] = newClient;
    }

    public float getClientBalance(Client clientToStudy) {
        return clientToStudy.getTotalBalance();
    }
    public void displayClientBalance(Client clientToStudy) {
        System.out.println(clientToStudy.getTotalBalance());
    }

    public void displayGeneralBalance () {
        float totalBalanceSheet = 0;
        for (int i=0; i<this.numberOfClients; i++) {
            totalBalanceSheet += this.clients[i].getTotalBalance();
        }
        System.out.println("The total balance of the bank is: " + String.format("%.2f", totalBalanceSheet));
    }
    public void bailoutAllClients() {
        for (int i=0; i<this.numberOfClients;i++) {
            this.clients[i].bailout();
        }
        System.out.println("All clients successfully bailed out");
    }
    public Bank (String bankName) {
        this.name = bankName;
    }
}

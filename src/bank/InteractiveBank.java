package bank;

import java.util.Scanner;

public class InteractiveBank {
    Bank bank;
    Scanner scanner;
    public int interaction() {
        System.out.println("Please select your operation: \n" +
                "1) Add new client\n" +
                "2) Perform operation on a client\n" +
                "3) Display general balance sheet\n" +
                "4) Bailout all clients\n");
        return this.scanner.nextInt();
    }

    public int secondInteraction() {
        System.out.println("Which operation do you want to operate?\n" +
                "1) Display balance\n" +
                "2) Deposit\n" +
                "3) Withdrawal\n" +
                "4) Transfer between accounts\n"+
                "5) Bailout\n");
        return this.scanner.nextInt();
    }

    public void interactionAddClient() {
        System.out.println("What is the name of your client?");
        Client newClient = new Client(scanner.next());
        this.bank.addClient(newClient);
        System.out.println(newClient.name +  " successfully added as a new client");
    }

    public Client interactionChooseClient() {
        System.out.println("Which client? Please enter a name: ");
        String selectedClientName = this.scanner.next();
        Client clientObject = null;
        for (Client client : this.bank.clients) {
            if (client.getName().equals(selectedClientName)) {
                clientObject = client;
                break;
            }
        }
        return clientObject;
    }
    public void interactionOperations(int choice, Client clientOperating) {
        if (choice == 1) {
            System.out.println("Which account do you want to check? Number 1 or number 2?");
            int accountNumber = scanner.nextInt();
            if (accountNumber == 1) {
                System.out.println("Your first account's balance is : " + clientOperating.accounts[0].getBalance());
            } else if (accountNumber ==2) {
                System.out.println("Your second account's balance is : " + clientOperating.accounts[1].getBalance());
            }

        } else if (choice == 2) {
            System.out.println("This account's balance is : " + clientOperating.accounts[0].getBalance());
            float depositValue = this.interactionDeposit();
            clientOperating.accounts[0].deposit(depositValue);
            System.out.println("The balance is now " + clientOperating.accounts[0].getBalance());

        } else if (choice == 3) {

            System.out.println("This account's balance is : " + clientOperating.accounts[0].getBalance());
            float withdrawalValue = this.interactionWithdrawal();
            clientOperating.accounts[0].withdrawal(withdrawalValue);
            System.out.println("The balance is now " + clientOperating.accounts[0].getBalance());

        } else if (choice == 4) {

            System.out.println("The first account's balance is : " + clientOperating.accounts[0].getBalance());
            System.out.println("The second account's balance is : " + clientOperating.accounts[1].getBalance());
            float transferValue = interactionTransfer();
            clientOperating.accounts[0].transfer(transferValue, clientOperating.accounts[1]);
            System.out.println("The first account's balance is now " + clientOperating.accounts[0].getBalance());
            System.out.println("The second account's balance is now : " + clientOperating.accounts[1].getBalance());
        } else if (choice == 5) {
            System.out.println("The first account's balance is : " + clientOperating.accounts[0].getBalance());
            System.out.println("The second account's balance is : " + clientOperating.accounts[1].getBalance());
            clientOperating.bailout();
            System.out.println("Bailout done.");
            System.out.println("The first account's balance is now " + clientOperating.accounts[0].getBalance());
            System.out.println("The second account's balance is now : " + clientOperating.accounts[1].getBalance());
        }else {
            System.out.println("Wrong input, please start over at the beginning");
        }
    }
    public void interactionDisplayTotalBank() {
        this.bank.displayGeneralBalance();
    }

    public void interactionBailoutAll() {
        this.bank.bailoutAllClients();
    }

    public float interactionDeposit() {
        System.out.println("How much do you want to deposit? ");
        return scanner.nextFloat();
    }

    public float interactionWithdrawal() {
        System.out.println("How much do you want to withdraw? ");
        return scanner.nextFloat();
    }

    public float interactionTransfer() {
        System.out.println("How much do you want to transfer?");
        return scanner.nextFloat();
    }
    InteractiveBank(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }
}

package bank;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        Client cyprien = new Client("Cyprien");
        Client lea = new Client("Lea");
        Bank cic = new Bank("cic");
        InteractiveBank cicInterface = new InteractiveBank(cic);

        cic.addClient(cyprien);
        cyprien.addAccount(new Account(1211));
        cyprien.addAccount(new Account(1212));
        cyprien.accounts[0].deposit(-2.22F);
        cyprien.accounts[1].deposit(50.00F);

        cic.addClient(lea);
        lea.addAccount(new Account(4221));
        lea.addAccount(new Account(4222));
        lea.accounts[0].deposit(55.25F);
        lea.accounts[1].deposit(112.89F);

        cyprien.displayBalance(cyprien.accounts[0]);
        lea.displayBalance(lea.accounts[1]);

        cyprien.displayTotalBalance();
        lea.displayTotalBalance();

        int choiceIntro = cicInterface.interaction();

        if (choiceIntro == 4) {
            cicInterface.interactionBailoutAll();
        }
        if (choiceIntro == 3) {
            cicInterface.interactionDisplayTotalBank();

        } else if (choiceIntro ==1) {
            cicInterface.interactionAddClient();

        } else if (choiceIntro == 2) {
            Client selectedClient = cicInterface.interactionChooseClient();
            int secondChoice = cicInterface.secondInteraction();
            cicInterface.interactionOperations(secondChoice, selectedClient);
        }
    }
}
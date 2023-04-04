package com.techelevator.tenmo;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Tenmo_user;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import com.techelevator.tenmo.security.model.AuthenticatedUser;
import com.techelevator.tenmo.security.model.User;
import com.techelevator.tenmo.security.model.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;
import com.techelevator.tenmo.services.TenmoService;

import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final TenmoService tenmoService = new TenmoService();
    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);


   // private final Account account = new Account();
    private final User user = new User();


   // private final RestTemplate theApiServer = new RestTemplate();

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewCurrentBalance() {
        Account account = tenmoService.getAccount(currentUser.getUser().getId());
        // instantiated object

            consoleService.displayBalance(account);

        }


	private void viewTransferHistory() {
		// TODO Auto-generated method stub
        //list all transfers for logged in user
        Account account = tenmoService.getAccount(currentUser.getUser().getId());

        Transfer[] transferList = tenmoService.allTransfers(account.getId());
        Transfer transferObject = new Transfer();



        consoleService.promptForTransfer(transferList);




		
	}

	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		
	}

	private void sendBucks() {
		// TODO Auto-generated method stub


        Tenmo_user[] tenmo_users = tenmoService.allUsers();
        boolean isValidId = false;
        int toID;
        if (tenmo_users != null) {
            consoleService.promptForUser(tenmo_users);
        } else {
            consoleService.printErrorMessage();
        }
        do {
            toID = consoleService.promptForInt("\"Please enter a User ID\" ");
            for(Tenmo_user user: tenmo_users){
                if(user.getId() == toID){
                    isValidId = true;
                    break;
                }
            }
           if(!isValidId){
               System.out.println("Please enter a valid user id"); }
        } while(!isValidId);
        // creating a transfer
        if (currentUser.getUser().getId() != toID) {

            Account senderAccount = tenmoService.getAccount(currentUser.getUser().getId());
            Account receivingAccount = tenmoService.getAccount(toID);

           BigDecimal transferAmount = consoleService.promptForBigDecimal("your current balance is: $" + senderAccount.getBalance() + "\n"+
                                                                                 "How much would you like to send?");


            // create transfer
            TransferDTO transferData = new TransferDTO();
            transferData.setFromAccount(senderAccount);
            transferData.setToAccount(receivingAccount);
            transferData.setAmount(transferAmount);

            BigDecimal CompareForNegativeOrZero = BigDecimal.valueOf(0);
            // .compareTo compares 2 amounts and checks if == 1 (so you cant send 0 or negative)
            if(transferData.getAmount().compareTo(CompareForNegativeOrZero) <= 0){
                System.out.println("Sorry " + currentUser.getUser().getUsername() + ", you entered either zero or a negative number. Please try again." );
            }
            // .compareTo compares 2 amounts and checks if > 0 (so you cant send more than you currently have)
            else if(transferData.getFromAccount().getBalance().compareTo(transferData.getAmount()) > 0) {
                tenmoService.createTransfer(transferData.getFromAccount(), transferData.getToAccount(), transferData.getAmount());
            } else {
                System.out.println("Sorry " + currentUser.getUser().getUsername() + ", you can't send more than you have. Please try again." );
            }
        } else {
            System.out.println("We told you not to select yourself, try again chump.");
        }


	}

	private void requestBucks() {
		// TODO Auto-generated method stub
		
	}

}
/*
 // .compareTo compares 2 amounts and checks if > 0 (so you cant send more than you currently have)
            if(transferData.getFromAccount().getBalance().compareTo(transferData.getAmount()) > 0) {
                tenmoService.createTransfer(transferData.getFromAccount(), transferData.getToAccount(), transferData.getAmount());
            } else {
                System.out.println("Sorry " + currentUser.getUser().getUsername() + ", you can't send more than you have. Please try again." );
            } // .compareTo compares 2 amounts and checks if == 1 (so you cant send 0 or negative)
            if(transferData.getFromAccount().getBalance().compareTo(transferData.getAmount()) == 1){
                System.out.println("Sorry " + currentUser.getUser().getUsername() + ", you entered either zero or a negative number. Please try again." );
            }
 */

package com.techelevator.tenmo;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.security.model.AuthenticatedUser;
import com.techelevator.tenmo.security.model.User;
import com.techelevator.tenmo.security.model.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;
import com.techelevator.tenmo.services.TenmoService;

import org.springframework.web.client.RestTemplate;

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

        //User user = currentUser.getUser();
       // System.out.println(user.getId()); // test method for debugging
        //System.out.println(currentUser.getUser().getId()); // test method for debugging
        //Account account = tenmoService.getAccount(user.getId());
        Account account = tenmoService.getAccount(currentUser.getUser().getId());
        // instantiated object
        consoleService.displayBalance(account);

        }

       //Account account = theApiServer.getForObject(API_BASE_URL + "account/" + user.getId(), Account.class );


	private void viewTransferHistory() {
		// TODO Auto-generated method stub
		
	}

	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		
	}

	private void sendBucks() {
		// TODO Auto-generated method stub
		
	}

	private void requestBucks() {
		// TODO Auto-generated method stub
		
	}

}

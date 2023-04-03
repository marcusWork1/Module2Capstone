package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Tenmo_user;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import com.techelevator.tenmo.security.model.UserCredentials;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleService {


    private final Account account = new Account();
    private BigDecimal amountSent;

    // This is for displaying messages

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username (lower case only): ");
        String password = promptForString("Password (lower case only): ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(prompt); // this was "please enter number"
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
              return BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    // add method to display balance
    public void displayBalance(Account account) {
            System.out.println("your balance is " + account.getBalance()); // get balance
    }
    public void promptForUser(Tenmo_user[] tenmoUser) {
// display users
        System.out.println("Select a user ID to send money to (You cannot select yourself)");
        for (Tenmo_user tenmo_user : tenmoUser) {
            System.out.println(tenmo_user.toString());
        }
            System.out.println();

    }
    public void promptForTransfer(Transfer[] transfers) {
// display users


        for (Transfer transfer : transfers) {
            System.out.println(transfer.toString());
        }
        System.out.println();

    }
//    public void selectAmount(Account account) {
//        //scanner input to collect ID
//        scanner.nextLine();
//
//        //create variable
//
//        System.out.println("Enter an amount to send");
//        // collect information turn into double
//    }

    }


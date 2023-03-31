package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.datasource.Account;
import com.techelevator.tenmo.datasource.AccountDAO;
import com.techelevator.tenmo.datasource.JDBCaccountDAO;
import com.techelevator.tenmo.datasource.Transfer;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

@RestController
@PermitAll
//@PreAuthorize("isAuthenticated()")
public class AccountController {

    private AccountDAO accountDAO;

    // constructor
    // dependency injection format >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public AccountController(AccountDAO anAccountDao) {
        this.accountDAO = anAccountDao;
    }

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public List<Account> listAllAccounts() {
        return accountDAO.getAllAccounts();
    }




    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable int id) {
        Account account = accountDAO.getAccountByUserId(id);
        if (account == null) {
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found.");
        } else {
            return account;
        }
        return account;
    }

    @RequestMapping(path = "/account/{id}", method = RequestMethod.PUT)
    public Account updateAccount (@Valid @RequestBody Account theAccount,
                                     @PathVariable int id) {
        Account theUpdatedAccount;
        theUpdatedAccount = accountDAO.updateBalance(theAccount);

        return theUpdatedAccount;
    }




//    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
//    public Account getAccountById(@PathVariable int id) {
//        Account account = accountDAO.getAccount(id);
//        if (account == null) {
//            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found.");
//        } else {
//            return account;
//        }
//        return account;
//    }

}// end of controller

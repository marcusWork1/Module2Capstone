package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.datasource.Account;
import com.techelevator.tenmo.datasource.JDBCaccountDAO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@PermitAll
//@PreAuthorize("isAuthenticated()")
public class AccountController {

    private JDBCaccountDAO accountDAO;

    // constructor
    public AccountController() {
        this.accountDAO = accountDAO;
    }

    @RequestMapping(path = "account", method = RequestMethod.GET)
    public List<Account> listAllAccounts() {
        return accountDAO.getAllAccounts();
    }


    @RequestMapping(path = "account/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable int id) {
        Account account = accountDAO.getAccount(id);
        if (account == null) {
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found.");
        } else {
            return account;
        }
        return account;
    }
}// end of controller

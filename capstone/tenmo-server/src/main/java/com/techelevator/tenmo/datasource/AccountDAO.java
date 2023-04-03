package com.techelevator.tenmo.datasource;

import java.math.BigDecimal;
import java.util.List;
// CRUD class to start off

public interface AccountDAO {



    public List<Account> getAllAccounts();

    public Account  getAccount(int id);

    public Account updateBalance(Account updatedAccount);

   // public Account subtractBalance(int id, BigDecimal amount);

    public Account getAccountByUserId(int id);

   // public Account getAccountById(int id);

    // public boolean checkValidTransfer(int id, double amount);

}

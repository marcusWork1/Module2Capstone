package com.techelevator.tenmo.datasource;

import java.util.List;
// CRUD class to start off

public interface AccountDAO {



    List<Account> getAllAccounts();

    public Account  getAccount(int id);

    public Account addBalance(int id, double amount);

    public Account subtractBalance(int id, double amount);

    public Account getAccountByUserId(int id);

   // public List<Account> getAllAccounts();

   // public Account getAccountById(int id);

    // public boolean checkValidTransfer(int id, double amount);


}

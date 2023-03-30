package com.techelevator.tenmo.datasource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCaccountDAO implements AccountDAO {

    private JdbcTemplate theServer;



    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        String sql = "SELECT * FROM account ;";

        SqlRowSet results = theServer.queryForRowSet(sql);
        while(results.next()) {
            Account accountResult = mapRowToAccount(results);
            accounts.add(accountResult);
        }
        return accounts;
    }

    @Override
    public Account getAccount(int id) {
        Account account = null;
        String sql = "SELECT * FROM account WHERE account_id = ? ;";
        SqlRowSet results = theServer.queryForRowSet(sql, id);

        if (results.next()) {
             account = mapRowToAccount(results);

        }
        return account;
    }

    @Override
    public Account addBalance(int id, double amount) { // .update
        return null;
    }

    @Override
    public Account subtractBalance(int id, double amount) { //.update
        return null;
    }

    @Override
    public Account getAccountByUserId(int id) {
        Account account = null;

        String sql = "SELECT * FROM account WHERE user_id = ? ;";

        SqlRowSet results = theServer.queryForRowSet(sql, id);
        if (results.next()) {
           account = mapRowToAccount(results);

        }
        return account;
    }

    private Account mapRowToAccount(SqlRowSet results) {
        Account account = new Account();
        account.setId(results.getInt("account_id"));
        account.setUserId(results.getInt("user_id"));
        account.setBalance(results.getDouble("balance"));
        return account;
    }

}

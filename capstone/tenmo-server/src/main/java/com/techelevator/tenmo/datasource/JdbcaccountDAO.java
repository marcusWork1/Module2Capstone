package com.techelevator.tenmo.datasource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component // indicates dependency injection(look at constructor methods)
public class JDBCaccountDAO implements AccountDAO {

    private JdbcTemplate theDatabase;

    // constructor with dependency injection format again >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public JDBCaccountDAO(JdbcTemplate jdbcTemplate) {
        this.theDatabase = jdbcTemplate;
    }


    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        String sql = "SELECT account_id, user_id, balance FROM account ;";

        SqlRowSet results = theDatabase.queryForRowSet(sql);
        while (results.next()) {
            Account accountResult = mapRowToAccount(results);
            accounts.add(accountResult);
        }
        return accounts;
    }

    @Override
    public Account getAccount(int id) {
        Account account = null;
        String sql = "SELECT * FROM account WHERE account_id = ? ;";
        SqlRowSet results = theDatabase.queryForRowSet(sql, id);

        if (results.next()) {
            account = mapRowToAccount(results);

        }
        return account;
    }

    @Override
    public Account updateBalance(Account updatedAccount) { // .update

        String sql = "UPDATE account SET balance = ? WHERE account_id = ? ;";

        theDatabase.update(sql, updatedAccount.getBalance(), updatedAccount.getId());

        return getAccount(updatedAccount.getId());
    }

    @Override
    public Account getAccountByUserId(int id) {
        Account account = null;

        String sql = "SELECT * FROM account WHERE user_id = ? ;";

        SqlRowSet results = theDatabase.queryForRowSet(sql, id);
        if (results.next()) {
           account = mapRowToAccount(results);

        }
        return account;
    }

    private Account mapRowToAccount(SqlRowSet results) {
        Account account = new Account();
        account.setId(results.getInt("account_id"));
        account.setUserId(results.getInt("user_id"));
        account.setBalance(results.getBigDecimal("balance"));
        return account;
    }

}

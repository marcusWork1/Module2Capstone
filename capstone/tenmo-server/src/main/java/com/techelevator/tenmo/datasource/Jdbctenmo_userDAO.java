package com.techelevator.tenmo.datasource;

import com.techelevator.tenmo.usermanagement.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCtenmo_userDAO implements Tenmo_userDAO {

    private JdbcTemplate theDatabase;

    public  JDBCtenmo_userDAO(JdbcTemplate jdbcTemplate) {this.theDatabase = jdbcTemplate;}


    @Override // gets a list of all users
    public List<Tenmo_user> getAllUsers() {
        List<Tenmo_user> tenmo_users = new ArrayList<>();
        String sql = "SELECT user_id, username, password_hash, role FROM tenmo_user ; ";
        SqlRowSet results = theDatabase.queryForRowSet(sql);
        while (results.next()) {
            Tenmo_user userResult = mapRowToUser(results);
            tenmo_users.add(userResult);
        }

        return tenmo_users;
    }

    @Override
    public Tenmo_user getUser(int id) {
        return null;
    }

    @Override
    public Tenmo_user getUserByName(String username) {
        return null;
    }

    @Override
    public Tenmo_user getRole(String role) {
        return null;
    }

    private Tenmo_user mapRowToUser(SqlRowSet results) {
       Tenmo_user tenmo_user = new Tenmo_user();
        tenmo_user.setId(results.getInt("user_id"));
        tenmo_user.setPassword(results.getString("password_hash"));
        tenmo_user.setRole(results.getString("role"));
        tenmo_user.setUsername(results.getString("username"));
        return tenmo_user;
    }
}

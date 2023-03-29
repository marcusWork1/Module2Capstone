package com.techelevator.tenmo.model;

public class Account {

    private int id;
    private double balance;
    private int userId;

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account Details" +
                "account id:" + id +
                ", balance:" + balance +
                ", userId:" + userId ;
    }
} // End of class

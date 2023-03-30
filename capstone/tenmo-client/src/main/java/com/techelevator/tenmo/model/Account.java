package com.techelevator.tenmo.model;

public class Account {

    private int id;
<<<<<<< HEAD
    private int userId;
    private double balance;
=======
    private double balance;
    private int userId;
>>>>>>> 8693167b4ad5464395ed7335d9bb43495c9100a3

    public int getId() {
        return id;
    }

<<<<<<< HEAD
    public void setId(int id) {
        this.id = id;
=======
    public double getBalance() {
        return balance;
>>>>>>> 8693167b4ad5464395ed7335d9bb43495c9100a3
    }

    public int getUserId() {
        return userId;
    }

<<<<<<< HEAD
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
=======
    public void setId(int id) {
        this.id = id;
>>>>>>> 8693167b4ad5464395ed7335d9bb43495c9100a3
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", balance=" + balance +
                '}';
    }
}// end of class
=======
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
>>>>>>> 8693167b4ad5464395ed7335d9bb43495c9100a3

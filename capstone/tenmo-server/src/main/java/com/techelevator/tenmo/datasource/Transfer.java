package com.techelevator.tenmo.datasource;

import java.math.BigDecimal;

// this also a plain old java object
public class Transfer {

    private int transferId;
    private int transferType;
    private int statusId;
    private int accountFrom;
    private int account_to;
    private BigDecimal amount;

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getTransferType() {
        return transferType;
    }

    public void setTransferType(int transferType) {
        this.transferType = transferType;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccount_to() {
        return account_to;
    }

    public void setAccount_to(int account_to) {
        this.account_to = account_to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", transferType=" + transferType +
                ", statusId=" + statusId +
                ", accountFrom=" + accountFrom +
                ", account_to=" + account_to +
                ", amount=" + amount +
                '}';
    }
}

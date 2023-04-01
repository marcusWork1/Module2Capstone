package com.techelevator.tenmo.datasource;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDAO {

    public Transfer getTransferById(int id); // detail of any transfer based on ID

    public List<Transfer> transferList(int id); // all transfers that have happened

    public Transfer createTransfer(TransferDTO transfer);
    // takes in both user ids
    // use user id to get account id
    // use account id's to create transfer rows

    // insert into account_from, account_to, balance

    public Transfer completeTransfer();



}

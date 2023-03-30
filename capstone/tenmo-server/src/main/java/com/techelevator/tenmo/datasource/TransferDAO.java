package com.techelevator.tenmo.datasource;

import java.util.List;

public interface TransferDAO {

    public Transfer getTransfer(int id); // detail of any transfer based on ID

    public List<Transfer> transferList(int id); // all transfers that have happened



}

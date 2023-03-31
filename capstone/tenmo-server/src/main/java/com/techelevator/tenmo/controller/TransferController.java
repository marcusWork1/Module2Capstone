package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.datasource.Account;
import com.techelevator.tenmo.datasource.AccountDAO;
import com.techelevator.tenmo.datasource.Transfer;
import com.techelevator.tenmo.datasource.TransferDAO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TransferController {

    private TransferDAO transferDAO;
    private AccountDAO accountDAO;

    public TransferController(TransferDAO aTransferDao, AccountDAO anAccountDAO) {this.transferDAO = aTransferDao; this.accountDAO = anAccountDAO;}

    @RequestMapping(path = "/transfer", method = RequestMethod.POST)
        public Transfer transferCreate(@Valid @RequestBody Transfer aTransfer ) {
        return transferDAO.createTransfer(aTransfer);
    }







//    @RequestMapping(path = "/transfer{id]", method = RequestMethod.PUT)
//    public Transfer completeTransfer(@Valid @RequestBody Transfer theTransfer,
//                                     @PathVariable int id)
//
//
//    }







}

package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.datasource.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TransferController {

    private TransferDAO transferDAO;
    private AccountDAO accountDAO;

    public TransferController(TransferDAO aTransferDao, AccountDAO anAccountDAO) {this.transferDAO = aTransferDao; this.accountDAO = anAccountDAO;}

    @RequestMapping(path = "/transfer", method = RequestMethod.POST)
        public Transfer transferCreate(@Valid @RequestBody TransferDTO aTransfer ) {
        accountDAO.updateBalance(aTransfer.getToAccount());
        accountDAO.updateBalance(aTransfer.getFromAccount());
        return transferDAO.createTransfer(aTransfer);
    }







//    @RequestMapping(path = "/transfer{id]", method = RequestMethod.PUT)
//    public Transfer completeTransfer(@Valid @RequestBody Transfer theTransfer,
//                                     @PathVariable int id)
//
//
//    }







}

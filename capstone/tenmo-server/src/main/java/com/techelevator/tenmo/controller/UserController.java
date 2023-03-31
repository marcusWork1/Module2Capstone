package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.datasource.Tenmo_user;
import com.techelevator.tenmo.datasource.Tenmo_userDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    // controller class contains Tenmo_userDAO object
    // create attribute
    private Tenmo_userDAO tenmo_userDAO;

    // constructor
    // dependency injection                             the tenmo_userDAO is equal to a tenmoUserDAO Class
    public UserController(Tenmo_userDAO aTenmoUserDao) {this.tenmo_userDAO = aTenmoUserDao;}

    @RequestMapping(path = "/tenmo_user", method = RequestMethod.GET)
    public List<Tenmo_user> userList() {return tenmo_userDAO.getAllUsers();}





}

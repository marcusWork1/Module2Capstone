package com.techelevator.tenmo.services;

import com.techelevator.tenmo.App;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Tenmo_user;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TenmoService {

    public String API_BASE_URL = "http://localhost:8080/";
    private String authToken = null;

    RestTemplate theApiServer = new RestTemplate();

    // Create method call from API SERVER to get user balance


    public Account getAccount(int id) {
        Account accountBalance = null;
        try {
            ResponseEntity<Account> response =
                    theApiServer.exchange(API_BASE_URL + "account/" + id,
                            HttpMethod.GET, makeAuthEntity(), Account.class);
            accountBalance = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return accountBalance;
    }
    public Tenmo_user[] allUsers() {
        Tenmo_user[] aUser = null;
        try {
            ResponseEntity<Tenmo_user[]> response =
                    theApiServer.exchange(API_BASE_URL + "tenmo_user",
                            HttpMethod.GET, makeAuthEntity(), Tenmo_user[].class);
            aUser = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return aUser;
        }


         // create a transfer
    public Transfer createTransfer(Transfer newTransfer){
        // maybe add a .getBody
Transfer transferCreated =  null;
try {
   transferCreated = theApiServer.postForObject(API_BASE_URL + "transfer/",
           makeTransferEntity(newTransfer), Transfer.class);
} catch (RestClientResponseException | ResourceAccessException e) {
    BasicLogger.log(e.getMessage());
}
        return newTransfer;
    }



    private HttpEntity<Transfer> makeTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    //    headers.setBearerAuth(authToken);
        return new HttpEntity<>(transfer, headers);
    }



    private HttpEntity<Void> makeAuthEntity() {   // helper method
        HttpHeaders headers = new HttpHeaders();  // Create an HTTP Header
     //   headers.setBearerAuth(authToken);       // Set the Authorization Bearer to the JWT
        return new HttpEntity<>(headers);         // Return the header
    }
//        HttpHeaders headers = createHeaders();
//        HttpEntity<> entity = new HttpEntity<>(headers);
//        ResponseEntity<Account> response = theApiServer.exchange(API_BASE_URL + "/balance", HttpMethod.GET, entity, Double.class);
//        return response.getBody();
//
//        accountBalance = response.getBody();


}// end of code


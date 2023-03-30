package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class TenmoService {

    public String API_BASE_URL = "http://localhost:8080/";

    RestTemplate theApiServer = new RestTemplate();

    // Create method call from API SERVER to get user balance

    public Account getAccount(int id) {
        Account accountBalance = new Account();
        try {
            ResponseEntity<Account> response =
                   theApiServer.exchange(API_BASE_URL + "account/" + id ,
                            HttpMethod.GET, makeAuthEntity(), Account.class);
            accountBalance = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return accountBalance;
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();  // Create an HTTP Header
       // headers.setBearerAuth(authToken);         // Set the Authorization Bearer to the JWT
        return new HttpEntity<>(headers);         // Return the header
    }




}// end of code


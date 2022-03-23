package com.example.htmlspring.services;

public class ValidateEmailService {
    public boolean isEmailValid(String email){
        boolean emailValid = false;
        boolean atFound = false;
        boolean pointFound = false;

        for (int i = 0; i < email.length(); i++) {
            String character = String.valueOf(email.charAt(i));


            if(character.equals("@")){
                atFound = true;
            }
            if(character.equals(".")){
                pointFound = true;
            }
            if(atFound && pointFound){
                emailValid = true;
            }
        }
        //TODO implement logic such that we verify an e-mail is valid
        return emailValid;
    }
}
/*
For the first iteration a valid e-mail contains a "@" an at least 1 "."
If the user enters a valid e-mail - direct them to a success site.
Use the PRG pattern described on this site above
 */
package com.company.bank.exceptions;

public class InvalidBanknoteDenominationException extends ATMException{
    public InvalidBanknoteDenominationException(){
        super("Invalid banknote denomination.");
    }
}

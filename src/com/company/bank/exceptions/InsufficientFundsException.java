package com.company.bank.exceptions;

public class InsufficientFundsException extends ATMException{
    public InsufficientFundsException(){
        super("Insufficient funds in the ATM.");
    }
}

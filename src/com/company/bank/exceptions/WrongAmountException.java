package com.company.bank.exceptions;

public class WrongAmountException extends ATMException{
    public WrongAmountException() {
        super("The amount must be greater than or equal to the minimum amount to be issued.");
    }
}

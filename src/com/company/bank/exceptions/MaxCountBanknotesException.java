package com.company.bank.exceptions;

public class MaxCountBanknotesException extends ATMException{
    public MaxCountBanknotesException(){
        super("The limit of banknotes at one time has been reached or insufficient number of banknotes.");
    }
}

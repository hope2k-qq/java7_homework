package com.company.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<ATM> atms;

    public Bank(int numAtms) {
        atms = new ArrayList<ATM>();
        for (int i = 0; i < numAtms; i++) {
            atms.add(new ATM());
        }
    }

    public int bankBalance(){
        int bankBalance = 0;
        for (ATM atm : atms) {
            bankBalance += atm.getBalance();
        }
        return bankBalance;
    }

    public List<ATM> getAtms() {
        return atms;
    }
}

package com.company.bank;

import com.company.bank.exceptions.InsufficientFundsException;
import com.company.bank.exceptions.InvalidBanknoteDenominationException;
import com.company.bank.exceptions.MaxCountBanknotesException;
import com.company.bank.exceptions.WrongAmountException;

import java.util.*;

public class ATM {
    private Map<Integer, Integer> banknotes;
    private int minWithdrawal;
    private int maxCountBanknotes;
    private int balance;

    public ATM() {
        banknotes = new HashMap<Integer, Integer>();
        banknotes.put(1, 0);
        banknotes.put(2, 0);
        banknotes.put(5, 0);
        banknotes.put(10, 0);
        banknotes.put(20, 0);
        banknotes.put(50, 0);
        banknotes.put(100, 0);
        banknotes.put(200, 0);
        banknotes.put(500, 0);
        minWithdrawal = 10;
        maxCountBanknotes = 70;
        balance = 0;
    }

    public void loadMoney(Map<Integer, Integer> banknotes) {
        for (int banknote : banknotes.keySet()) {
            if (this.banknotes.containsKey(banknote)) {
                int count = banknotes.get(banknote);
                this.banknotes.put(banknote, this.banknotes.get(banknote) + count);
                balance += banknote * count;
            }
        }
    }

    public void depositMoney(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert banknotes one by one. Enter 0 to finish.");

        int insertedAmount = 0;

        while (true) {
            try{
                System.out.print("Insert a banknote (enter it's denomination): ");
                int denomination = scanner.nextInt();

                if (denomination == 0) {
                    break;
                }

                if (banknotes.containsKey(denomination)) {
                    banknotes.put(denomination, banknotes.get(denomination) + 1);
                    balance += denomination;
                    insertedAmount += denomination;
                } else {
                    throw new InvalidBanknoteDenominationException();
                }
            } catch (InvalidBanknoteDenominationException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: It's not a number.");
                scanner.nextLine();
            }
        }
        System.out.println("Total amount inserted: " + insertedAmount);
    }

    public void withdrawingMoney() {
        Scanner scanner = new Scanner(System.in);
        int amount = 0;

        System.out.print("Enter the amount you want to withdraw, or 0 to cancel: ");
        while (true) {
            try {
                amount = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: It's not a number.");
                System.out.print("Enter new amount or 0 to cancel: ");
                scanner.nextLine();
            }
        }

        if (amount == 0) {
            System.out.println("Operation canceled.");
        } else {
            while (true) {
                try {
                    if (amount < minWithdrawal) {
                        throw new WrongAmountException();
                    }

                    if (amount > balance) {
                        throw new InsufficientFundsException();
                    }

                    List<Integer> sortedBanknotes = new ArrayList<Integer>(banknotes.keySet());
                    Collections.sort(sortedBanknotes, Collections.reverseOrder());

                    int amountToIssued = amount;
                    int totalNumBanknotes = 0;
                    for (int banknote : sortedBanknotes) {
                        int numBanknotes = Math.min(maxCountBanknotes, banknotes.get(banknote));
                        if (banknote * numBanknotes > amountToIssued) {
                            numBanknotes = amountToIssued / banknote;
                        }
                        amountToIssued -= numBanknotes * banknote;
                        totalNumBanknotes += numBanknotes;
                    }

                    if (amountToIssued > 0 || totalNumBanknotes > maxCountBanknotes) {
                        throw new MaxCountBanknotesException();
                    }

                    for (int banknote : sortedBanknotes) {
                        if (banknote <= amount && banknotes.get(banknote) > 0) {
                            int numBanknotes = Math.min(amount / banknote, banknotes.get(banknote));
                            amount -= banknote * numBanknotes;
                            banknotes.put(banknote, banknotes.get(banknote) - numBanknotes);
                            balance -= banknote * numBanknotes;
                            System.out.println("You took " + numBanknotes + " banknotes denomination "
                                    + banknote + " UAN.");
                        }
                    }
                    if (amount == 0) {
                        System.out.println("The operation was completed successfully.");
                        break;
                    }
                } catch (WrongAmountException | InsufficientFundsException | MaxCountBanknotesException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.print("Enter new amount or 0 to cancel: ");
                    amount = scanner.nextInt();
                    if (amount == 0) {
                        System.out.println("Operation canceled.");
                        break;
                    }
                }
            }
        }
    }

    public int getBalance() {
        return balance;
    }

    public Map<Integer, Integer> getBanknotes() {
        return banknotes;
    }
}

package com.company;

import com.company.bank.ATM;
import com.company.bank.Bank;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank(2);

        List<ATM> atms = bank.getAtms();

        ATM atm1 = atms.get(0);
        ATM atm2 = atms.get(1);

        int num = 0;
        while(true){
            try{
                System.out.println("\nFill one of the ATMs with money - 1\nDeposit money into one of the ATMs - 2\n" +
                        "Withdraw money from one of the ATMs - 3\nFind out the balance of one of the ATMs - 4\n" +
                        "Find out the bank balance - 5\nFinish the program - 0\n");

                System.out.print("Enter digit: ");
                num = scanner.nextInt();

                switch (num){
                    case 1:
                        do {
                            try{
                                System.out.println("\nFill ATM No. 1 with money - 1\nFill ATM No. 2 with money - 2\n" +
                                        "Press any number to go back\n");

                                System.out.print("Enter digit: ");
                                int case1Value = scanner.nextInt();

                                switch (case1Value){
                                    case 1:
                                        Map<Integer, Integer> moneyToLoadATM1 = new HashMap<>();

                                        moneyToLoadATM1.put(500, 10);
                                        moneyToLoadATM1.put(200, 15);
                                        moneyToLoadATM1.put(100, 20);
                                        moneyToLoadATM1.put(50, 35);
                                        moneyToLoadATM1.put(20, 40);
                                        moneyToLoadATM1.put(10, 45);
                                        moneyToLoadATM1.put(5, 60);
                                        moneyToLoadATM1.put(2, 75);
                                        moneyToLoadATM1.put(1, 100);

                                        atm1.loadMoney(moneyToLoadATM1);

                                        System.out.println("Successfully filling ATM No. 1");
                                        break;
                                    case 2:
                                        Map<Integer, Integer> moneyToLoadATM2 = new HashMap<>();

                                        moneyToLoadATM2.put(500, 8);
                                        moneyToLoadATM2.put(200, 13);
                                        moneyToLoadATM2.put(100, 18);
                                        moneyToLoadATM2.put(50, 33);
                                        moneyToLoadATM2.put(20, 38);
                                        moneyToLoadATM2.put(10, 45);
                                        moneyToLoadATM2.put(5, 58);
                                        moneyToLoadATM2.put(2, 72);
                                        moneyToLoadATM2.put(1, 142);

                                        atm2.loadMoney(moneyToLoadATM2);

                                        System.out.println("Successfully filling ATM No. 2");
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: It's not a number.");
                                scanner.next();
                            }
                        } while (true);
                        break;
                    case 2:
                        do {
                            try{
                                System.out.println("\nDeposit ATM No. 1 with money - 1" +
                                        "\nDeposit ATM No. 2 with money - 2\n" +
                                        "Press any number to go back\n");
                                System.out.print("Enter digit: ");
                                int case2Value = scanner.nextInt();
                                switch (case2Value){
                                    case 1:
                                        atm1.depositMoney();
                                        break;
                                    case 2:
                                        atm2.depositMoney();
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            } catch (InputMismatchException e){
                                System.out.println("Error: It's not a number.");
                                scanner.next();
                            }
                        } while (true);
                        break;
                    case 3:
                        do {
                            try {
                                System.out.println("\nWithdrawing money from ATM No. 1 - 1" +
                                        "\nWithdrawing money from ATM No. 2 - 2\n" +
                                        "Press any number to go back\n");
                                System.out.print("Enter digit: ");
                                int case3Value = scanner.nextInt();
                                switch (case3Value){
                                    case 1:
                                        atm1.withdrawingMoney();
                                        break;
                                    case 2:
                                        atm2.withdrawingMoney();
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: It's not a number.");
                                scanner.next();
                            }
                        } while (true);
                        break;

                    case 4:
                        do{
                            try {
                                System.out.println("\nATM balance No. 1 - 1\nATM balance No. 2 - 2\n" +
                                        "Press any number to go back\n");
                                System.out.print("Enter digit: ");
                                int case4Value = scanner.nextInt();
                                switch (case4Value){
                                    case 1:
                                        System.out.print("Balance: " + atm1.getBalance());
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.print("Balance: " + atm2.getBalance());
                                        System.out.println();
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }catch (InputMismatchException e) {
                                System.out.println("Error: It's not a number.");
                                scanner.next();
                            }
                        } while (true);
                        break;
                    case 5:
                        System.out.println("Balance bank: " + bank.bankBalance());
                        break;
                    default:
                        if(num == 0){
                            return;
                        }
                        System.out.println("Invalid choice. Enter the correct value.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: It's not a number.");
                scanner.next();
            }

        }

    }
}

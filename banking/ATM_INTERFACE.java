package banking;

import java.util.Scanner;

class BankAccount {
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    public final void clrscr() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void checkId() {
        clrscr();
        System.out.println("welcome " + customerName);
        System.out.println();
        System.out.println("plz enter the customer ID or PIN:");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(customerId)) {
            clrscr();
            showMenu();
        } else {
            System.out.println("............");
            System.out.println("wrong login!!");
            System.out.println("...............");
            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            clrscr();
            System.out.println("...............");
            System.out.println("Sufficient Balance not available for the withdrawal!!");
            System.out.println("...............");
        }
    }

    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Occurred");
        }
    }

    public void transfer(double amount, BankAccount acc) {
        if (this.balance < amount) {
            clrscr();
            System.out.println(".................");
            System.out.println("Transfer fails due to insufficient balance!");
            System.out.println("...................");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.customerName + " becomes $" + this.balance);
            System.out.println("Account of " + acc.customerName + " becomes $" + acc.balance);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        do {
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Transfer");
            System.out.println("F. Exit");
            System.out.println("...............");
            System.out.println("Enter the option");
            System.out.println("..................");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    clrscr();
                    System.out.println(".............");
                    System.out.println("Balance " + balance);
                    System.out.println(".................");
                    System.out.println("\n");
                    break;

                case 'B':
                    clrscr();
                    System.out.println("..................");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("......................");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    clrscr();
                    System.out.println("..................");
                    System.out.println("Enter the amount to withdraw");
                    System.out.println("......................");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    clrscr();
                    System.out.println("..................");
                    getPrevTransaction();
                    System.out.println("..................");
                    System.out.println("\n");
                    break;

                case 'E':
                    clrscr();
                    System.out.println("..................");
                    System.out.println("To whom");
                    BankAccount bb = new BankAccount("Nikitagadekar", "2003");
                    System.out.println(bb.customerName);
                    System.out.println("..................");
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    System.out.println("..................");
                    transfer(am, bb);
                    break;

                case 'F':
                    clrscr();
                    System.out.println("..................");
                    break;

                default:
                    clrscr();
                    System.out.println("Invalid Option!! please Enter Again");
            }
        } while (option != 'F');
        System.out.println("Thank You For Using services");
    }
}

public class ATM_INTERFACE {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("NikitaGadekar", "1123");
        ba.checkId();
    }
}

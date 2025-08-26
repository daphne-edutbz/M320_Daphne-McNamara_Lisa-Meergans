package ch.tbz;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    public void process() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("1001", "Daphne"));
        accounts.add(new BankAccount("1002", "Lisa"));
        accounts.add(new BankAccount("1003", "Elif"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1) Choose an account");
            System.out.println("2) End");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Available Accounts:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ") " + accounts.get(i).getOwner() +
                                " (Balance: " + accounts.get(i).getBalance() + ")");
                    }

                    System.out.print("Choose account: ");
                    int accountChoice = scanner.nextInt();
                    BankAccount activeAccount = accounts.get(accountChoice - 1);

                    System.out.println("Chosen account: " + activeAccount.getOwner());
                    System.out.println("Actions: 1) Deposit  2) Withdraw  3) Transfer");
                    int action = scanner.nextInt();

                    if (action == 1) {
                        System.out.print("Amount: ");
                        double amount = scanner.nextDouble();
                        activeAccount.deposit(amount);

                    } else if (action == 2) {
                        System.out.print("Amount: ");
                        double amount = scanner.nextDouble();
                        activeAccount.withdraw(amount);

                    } else if (action == 3) {
                        System.out.print("Amount: ");
                        double amount = scanner.nextDouble();

                        System.out.println("Transfer to which account?");
                        for (int i = 0; i < accounts.size(); i++) {
                            if (accounts.get(i) != activeAccount) {
                                System.out.println((i + 1) + ") " + accounts.get(i).getOwner());
                            }
                        }

                        int destChoice = scanner.nextInt();
                        BankAccount destination = accounts.get(destChoice - 1);

                        activeAccount.transfer(amount, destination);
                    }
                    break;

                case 2:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}

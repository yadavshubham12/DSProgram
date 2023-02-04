package com.blz.datastructure;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class CashCounter {
    static int balance = 10000;

        public static void main(String[] args) {
            Queue<Transaction> queue = new LinkedList<>();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add transaction");
                System.out.println("2. Process next transaction");
                System.out.println("3. Exit");
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter 1 to deposit, 2 to withdraw: ");
                        int type = sc.nextInt();
                        System.out.println("Enter amount: ");
                        int amount = sc.nextInt();
                        queue.add(new Transaction(type, amount));
                        break;
                    case 2:
                        if (!queue.isEmpty()) {
                            Transaction t = queue.poll();
                            if (t.type == 1) {
                                balance = balance + t.amount;
                                System.out.println("Deposited: " + t.amount);
                            } else {
                                if (balance >= t.amount) {
                     balance = balance - t.amount;
                       System.out.println("Withdrawn: " + t.amount);
                     } else {
                         System.out.println("Insufficient balance");
                          }
                       }
                     } else {
                        System.out.println("No transactions");
                   }
                   break;
             case 3:
             System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }

    class Transaction {
        int type;
        int amount;

        public Transaction(int type, int amount) {
            this.type = type;
            this.amount = amount;
        }
    }
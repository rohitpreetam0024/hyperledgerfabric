package account;

import java.util.*;

public class Main {
    private static Account findAccount(ArrayList<Account> accounts, String dealerID) {
        for (Account account : accounts) {
            if (account.getDealerID().equals(dealerID)) {
                return account;
            }
        }
        return null; 
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();


        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account details");
            System.out.println("5. Transaction history");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Creating a new account");
                    System.out.print("Enter Dealer ID: ");
                    String dealerID = scanner.nextLine();

                    System.out.print("Enter MSISDN (Mobile Number): ");
                    String msisdn = scanner.nextLine();

                    System.out.print("Set MPIN (4-digit): ");
                    String mpin = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); 

                    String status = "Active";

                    accounts.add(new Account(dealerID, msisdn, mpin, balance, status));
                    System.out.println("Account created successfully!");
                    break;

                case 2: 
                    System.out.print("Enter Dealer ID to deposit into: ");
                    String DealerID = scanner.nextLine();
                    Account accountToDeposit = findAccount(accounts, DealerID);

                    if (accountToDeposit != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter Remarks: ");
                        String depositRemarks = scanner.nextLine();

                        System.out.print("Enter MPIN for verification: ");
                        String depositMpin = scanner.nextLine();

                        if (accountToDeposit.verifypin(depositMpin)) {
                            accountToDeposit.deposit(depositAmount, depositRemarks);
                            System.out.println("Deposit successful. New Balance: " + accountToDeposit.getBalance());
                        } else {
                            System.out.println("Invalid MPIN! Transaction failed.");
                        }
                    } else {
                        System.out.println("Account not found with Dealer ID: " + DealerID);
                    }
                    break;

                case 3: 
                    System.out.print("Enter Dealer ID to withdraw from: ");
                    String DealerID = scanner.nextLine();
                    Account accountToWithdraw = findAccount(accounts, DealerID);

                    if (accountToWithdraw != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); 

                        System.out.print("Enter Remarks: ");
                        String withdrawRemarks = scanner.nextLine();

                        System.out.print("Enter MPIN for verification: ");
                        String withdrawMpin = scanner.nextLine();

                        if (accountToWithdraw.verifypin(withdrawMpin)) {
                            if (accountToWithdraw.withdraw(withdrawAmount, withdrawRemarks)) {
                                System.out.println("Withdrawal successful. New Balance: " + accountToWithdraw.getBalance());
                            } else {
                                System.out.println("Insufficient balance! Transaction failed.");
                            }
                        } else {
                            System.out.println("Invalid MPIN! Transaction failed.");
                        }
                    } else {
                        System.out.println("Account not found with Dealer ID: " + DealerID);
                    }
                    break;

                case 4:
                    System.out.print("Enter Dealer ID to show details: ");
                    String DealerID = scanner.nextLine();
                    Account accountDetails = findAccount(accounts, DealerID);
                    if (accountDetails != null) {
                        accountDetails.showAccountDetails();
                    } else {
                        System.out.println("Account not found with Dealer ID: " + DealerID);
                    }
                    break;

                case 5: 
                    System.out.print("Enter Dealer ID to show history: ");
                    String DealerID = scanner.nextLine();
                    Account accountHistory = findAccount(accounts, DealerID);
                    if (accountHistory != null) {
                        accountHistory.showTransactionHistory();
                    } else {
                        System.out.println("Account not found with Dealer ID: " + DealerID);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }



}

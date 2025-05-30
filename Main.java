import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("National Bank");

        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Customer customer = new Customer(customerName);
                    bank.addCustomer(customer);
                    System.out.println("Customer added.");
                }

                case 2 -> {
                    System.out.print("Enter customer name: ");
                    String custName = scanner.nextLine();
                    Customer c = bank.findCustomer(custName);
                    if (c == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    System.out.print("Enter new account number: ");
                    String accNum = scanner.nextLine();
                    Account account = new Account(accNum);
                    c.addAccount(account);
                    System.out.println("Account created.");
                }

                case 3 -> {
                    System.out.print("Enter customer name: ");
                    String custNameD = scanner.nextLine();
                    Customer custD = bank.findCustomer(custNameD);
                    if (custD == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    System.out.print("Enter account number: ");
                    String accD = scanner.nextLine();
                    Account accDeposit = custD.getAccount(accD);
                    if (accDeposit == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    accDeposit.deposit(depositAmount);
                }

                case 4 -> {
                    System.out.print("Enter customer name: ");
                    String custNameW = scanner.nextLine();
                    Customer custW = bank.findCustomer(custNameW);
                    if (custW == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    System.out.print("Enter account number: ");
                    String accW = scanner.nextLine();
                    Account accWithdraw = custW.getAccount(accW);
                    if (accWithdraw == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    accWithdraw.withdraw(withdrawAmount);
                }

                case 5 -> {
                    System.out.print("Enter customer name: ");
                    String custNameB = scanner.nextLine();
                    Customer custB = bank.findCustomer(custNameB);
                    if (custB == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    System.out.print("Enter account number: ");
                    String accB = scanner.nextLine();
                    Account accBalance = custB.getAccount(accB);
                    if (accBalance == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.println("Current balance: $" + accBalance.getBalance());
                }

                case 0 -> {
                    System.out.println("Thank you for using the banking system!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

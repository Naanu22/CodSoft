import java.util.Scanner;

// 🏦 Class to represent a bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Add money to the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Take money out of the account
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; // Not enough funds
        } else {
            balance -= amount;
            return true;
        }
    }

    // Show current balance
    public double getBalance() {
        return balance;
    }
}

//  Class to represent the ATM
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Show the menu and handle user choices
    public void start() {
        System.out.println("Welcome to the ATM!");

        boolean running = true;
        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1.  Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    running = false;
                    System.out.println("👋 Thank you for using the ATM. Have a good day!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void checkBalance() {
        System.out.printf("💰 Your current balance is: ₹%.2f\n", account.getBalance());
    }

    private void deposit() {
        System.out.print("💵 Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than zero.");
        } else {
            account.deposit(amount);
            System.out.println("✅ Deposit successful.");
            checkBalance();
        }
    }

    private void withdraw() {
        System.out.print("💸 Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than zero.");
        } else if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful.");
            checkBalance();
        } else {
            System.out.println("❌ Insufficient balance. Transaction failed.");
        }
    }
}

// 🧾 Main class to run the program
public class ATMInterface {
    public static void main(String[] args) {
        // Let's assume the user starts with ₹10,000 in their account
        BankAccount userAccount = new BankAccount(10000.00);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

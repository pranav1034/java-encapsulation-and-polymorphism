// Abstract superclass
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract double calculateInterest(); // Abstract method

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

// Interface for loan-related features
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Savings Account subclass
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.06; // 6% annual interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// Current Account subclass
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2% annual interest

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for $" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance > 50000; // Eligibility based on balance threshold
    }

    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("S123", "Pranav", 50000);
        BankAccount current = new CurrentAccount("C456", "Nikhil", 10000);

        savings.displayDetails();
        savings.deposit(10000);
        System.out.println("Interest: $" + savings.calculateInterest());
//        savings.displayDetails();

        System.out.println();

        current.displayDetails();
        current.withdraw(2000);
        System.out.println("Interest: $" + current.calculateInterest());
//        current.displayDetails();

        System.out.println();

        CurrentAccount loanAccount = new CurrentAccount("L789", "Abhay", 60000);
        loanAccount.displayDetails();
        loanAccount.applyForLoan(20000);
        System.out.println("Loan Eligible: " + loanAccount.calculateLoanEligibility());
    }
}

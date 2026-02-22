import java.util.*;

class CashFree {
    protected String name;
    protected int codeno;
    protected String location;
    protected double viewbalance;
    
    public CashFree(String name, int codeno, String location) {
        this.name = name;
        this.codeno = codeno;
        this.location = location;
    }
    
    public void ViewBalance() {
        System.out.println("Current Balance: " + viewbalance);
    }
    
    public void WithDraw(double amount) {
        if (amount <= viewbalance) {
            viewbalance = viewbalance - amount;
            System.out.println("Withdrawal successful: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    public void Deposit(double amount) {
        viewbalance = viewbalance + amount;
        System.out.println("Deposit successful: " + amount);
    }
    
    public void displayAccountDetails() {
        System.out.println("___Account Details___");
        System.out.println("Account Holder codeno: " + codeno);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Account Holder Location: " + location);
        System.out.println("Current Balance: " + viewbalance);
    }
}

class SBI_Bank extends CashFree {
    private String cust_name;
    private String accno;
    private double servicecharge;
    private double interestrate;
    
    public SBI_Bank(String name, int codeno, String location, String cust_name, String accno, double balance) {
        super(name, codeno, location);
        this.cust_name = cust_name;
        this.accno = accno;
        this.viewbalance = balance;
        this.servicecharge = 5.0;
        this.interestrate = 6.0;
    }
    
    public void ViewBalance() {
        System.out.println("___SBI Bank Details___");
        System.out.println("Bank Name: " + name);
        System.out.println("Customer Name: " + cust_name);
        System.out.println("Account Number: " + accno);
        System.out.println("Current Balance: " + viewbalance);
        System.out.println("Service Charge: " + servicecharge);
        System.out.println("Interest Rate: " + interestrate + "%");
    }
    
    public void WithDraw(double amount) {
        double totalAmount = amount + servicecharge;
        if (totalAmount <= viewbalance) {
            viewbalance = viewbalance - totalAmount;
            System.out.println("Withdrawal successful!");
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Service charge: " + servicecharge);
            System.out.println("Remaining balance: " + viewbalance);
        } else {
            System.out.println("Insufficient balance for withdrawal!");
        }
    }
    
    public void Deposit(double amount) {
        viewbalance = viewbalance + amount;
        double interest = (amount * interestrate) / 100;
        viewbalance = viewbalance + interest;
        System.out.println("Deposit successful!");
        System.out.println("Amount deposited: " + amount);
        System.out.println("Interest added: " + interest);
        System.out.println("New balance: " + viewbalance);
    }
}

class HDFC_Bank extends CashFree {
    private String cust_name;
    private String accno;
    private double servicecharge;
    private double interestrate;
    
    public HDFC_Bank(String name, int codeno, String location, String cust_name, String accno, double balance) {
        super(name, codeno, location);
        this.cust_name = cust_name;
        this.accno = accno;
        this.viewbalance = balance;
        this.servicecharge = 10.0;
        this.interestrate = 5.0;
    }
    
    public void ViewBalance() {
        System.out.println("___HDFC Bank Details___");
        System.out.println("Bank Name: " + name);
        System.out.println("Customer Name: " + cust_name);
        System.out.println("Account Number: " + accno);
        System.out.println("Current Balance: " + viewbalance);
        System.out.println("Service Charge: " + servicecharge);
        System.out.println("Interest Rate: " + interestrate + "%");
    }
    
    public void WithDraw(double amount) {
        double totalAmount = amount + servicecharge;
        if (totalAmount <= viewbalance) {
            viewbalance = viewbalance - totalAmount;
            System.out.println("Withdrawal successful!");
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Service charge: " + servicecharge);
            System.out.println("Remaining balance: " + viewbalance);
        } else {
            System.out.println("Insufficient balance for withdrawal!");
        }
    }
    
    public void Deposit(double amount) {
        viewbalance = viewbalance + amount;
        double interest = (amount * interestrate) / 100;
        viewbalance = viewbalance + interest;
        System.out.println("Deposit successful!");
        System.out.println("Amount deposited: " + amount);
        System.out.println("Interest added: " + interest);
        System.out.println("New balance: " + viewbalance);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CashFree account = null;
        
        System.out.println("Welcome to Banking System!");
        System.out.println("1. SBI Bank");
        System.out.println("2. HDFC Bank");
        System.out.print("Select your bank: ");
        int bankChoice = input.nextInt();
        input.nextLine();
        
        System.out.print("Enter customer name: ");
        String custName = input.nextLine();
        
        System.out.print("Enter account number: ");
        String accountNo = input.nextLine();
        
        System.out.print("Enter initial balance: ");
        double initialBalance = input.nextDouble();
        
        if (bankChoice == 1) {
            account = new SBI_Bank("State Bank of India", 1001, "Mumbai", custName, accountNo, initialBalance);
        } else if (bankChoice == 2) {
            account = new HDFC_Bank("HDFC Bank", 2001, "Delhi", custName, accountNo, initialBalance);
        } else {
            System.out.println("Invalid choice!");
            return;
        }
        
        while (true) {
            System.out.println("\n--- Banking Operations ---");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            
            if (choice == 1) {
                account.ViewBalance();
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = input.nextDouble();
                account.WithDraw(withdrawAmount);
            } else if (choice == 3) {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = input.nextDouble();
                account.Deposit(depositAmount);
            } else if (choice == 4) {
                account.displayAccountDetails();
            } else if (choice == 5) {
                System.out.println("Thank you for using Banking System!");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
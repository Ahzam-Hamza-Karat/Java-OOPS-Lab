import java.util.*;
public class SimpleBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentBalance = 10000;
        int option;
        do {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Your current balance is: " + currentBalance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        currentBalance += depositAmount;
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Please enter a positive amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0 && withdrawalAmount <= currentBalance) {
                        currentBalance -= withdrawalAmount;
                        System.out.println("Withdrawal successful.");
                    } else if (withdrawalAmount > currentBalance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        System.out.println("Please enter a positive amount.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM service.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }
}
import java.util.*;
public class ElectricityUsage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int months = 12;
        int[] unitsUsed = new int[months];
        int totalUnits = 0;
        System.out.println("Enter electricity units used for each month:");
        for (int i = 0; i < months; i++) {
            System.out.print("Month " + (i + 1) + ": ");
            unitsUsed[i] = sc.nextInt();
            totalUnits += unitsUsed[i];
        }
        double averageUsage = totalUnits / (double) months;
        System.out.println("Total units used: " + totalUnits);
        System.out.printf("Average monthly usage: %.2f\n", averageUsage);
        if (averageUsage > 500) {
            System.out.println("High Consumption Alert!");
        }
    }
}
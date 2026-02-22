import java.util.*;
public class CinemaTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int basePrice = 200;
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter day (Mon, Tue, Wed, Thu, Fri, Sat, Sun): ");
        String day = sc.next();
        double ticketPrice = basePrice;
        if (age < 5) {
            ticketPrice = 0;
        } else if (age <= 18) {
            ticketPrice = basePrice * 0.6;
        } else if (age > 60) {
            ticketPrice = basePrice * 0.7;
        }
       
        if (ticketPrice > 0) {
            if (day.equalsIgnoreCase("Mon") || day.equalsIgnoreCase("Tue") ||
                day.equalsIgnoreCase("Wed") || day.equalsIgnoreCase("Thu") ||
                day.equalsIgnoreCase("Fri")) {
                ticketPrice = ticketPrice * 0.9;
            }
        }
       
        System.out.println("Ticket Price: " + ticketPrice);
        sc.close();
    }
}
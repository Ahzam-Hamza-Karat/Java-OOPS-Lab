import java.util.Scanner;

public class Palindromechecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the String: ");
        String originalString = input.nextLine();
        
        String reversedString = "";
        
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i);
        }
        
        if (originalString.equals(reversedString)) {
            System.out.println("The given string is a PALINDROME");
        } else {
            System.out.println("The given string is not a PALINDROME");
        }
    }
}
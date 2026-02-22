import java.util.Scanner;

public class LetterandDigitcounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();
        
        int letterCount = 0;
        int digitCount = 0;
        
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            
            if (Character.isLetter(currentChar)) {
                letterCount = letterCount + 1;
            }
            
            if (Character.isDigit(currentChar)) {
                digitCount = digitCount + 1;
            }
        }
        
        System.out.println("Letters: " + letterCount);
        System.out.println("Digits: " + digitCount);
        
    }
}
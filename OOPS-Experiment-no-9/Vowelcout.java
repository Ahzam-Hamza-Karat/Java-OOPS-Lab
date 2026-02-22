import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Vowelcout {
    public static void main(String[] args) {
        String fileName = "notes.txt";
        int totalVowels = 0;

        int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int ch;
            while ((ch = br.read()) != -1) {
                char c = Character.toLowerCase((char) ch);
                switch (c) {
                    case 'a':
                        aCount++;
                        totalVowels++;
                        break;
                    case 'e':
                        eCount++;
                        totalVowels++;
                        break;
                    case 'i':
                        iCount++;
                        totalVowels++;
                        break;
                    case 'o':
                        oCount++;
                        totalVowels++;
                        break;
                    case 'u':
                        uCount++;
                        totalVowels++;
                        break;
                }
            }

            System.out.println("Total number of vowels: " + totalVowels);
            System.out.println("Count of each vowel:");
            System.out.println("a: " + aCount);
            System.out.println("e: " + eCount);
            System.out.println("i: " + iCount);
            System.out.println("o: " + oCount);
            System.out.println("u: " + uCount);

            int maxCount = aCount;
            char mostFrequent = 'a';

            if (eCount > maxCount) { maxCount = eCount; mostFrequent = 'e'; }
            if (iCount > maxCount) { maxCount = iCount; mostFrequent = 'i'; }
            if (oCount > maxCount) { maxCount = oCount; mostFrequent = 'o'; }
            if (uCount > maxCount) { maxCount = uCount; mostFrequent = 'u'; }

            System.out.println("Most frequent vowel: " + mostFrequent + " (" + maxCount + " times)");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

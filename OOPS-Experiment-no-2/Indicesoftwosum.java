import java.util.*;
public class Indicesoftwosum {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Please enter numbers separated by spaces: ");
        String line = inputScanner.nextLine();
        String[] numberStrings = line.split(" ");
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++)
        {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }
        System.out.print("Enter the target sum: ");
        int targetSum = inputScanner.nextInt();

        boolean pairFound = false;
        for (int first = 0; first < numbers.length; first++)
        {
            for (int second = first + 1; second < numbers.length; second++)
            {
                if (numbers[first] + numbers[second] == targetSum)
                {
                    System.out.println("Indices found: " + first + ", " + second);
                    System.out.println("Explanation: numbers[" + first + "] + numbers[" + second + "] = "  + numbers[first] + " + " + numbers[second] + " = " + targetSum);
                    pairFound = true;
                    break;
                }
            }
            if (pairFound)
            {
                break;
            }
        }
    }
}

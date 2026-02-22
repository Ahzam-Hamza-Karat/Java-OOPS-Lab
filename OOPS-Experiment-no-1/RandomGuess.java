import java.util.*;
public class RandomGuess {
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int ran = r.nextInt(101);
        System.out.println("A random number is created, you have to guess it!");
        int chance = 1, num = -1;
        while (num != ran && chance <= 5) 
        {
            System.out.println("Enter your guessed number:");
            num = sc.nextInt();
            if (num == ran) 
            {
                System.out.println("The number you guessed is correct! You got it in " + chance + " chance(s).");
                break;
            }
            else if (num > ran) 
            {
                System.out.println("The number you guessed is too high.");
                chance++;
            } 
            else if (num<ran)
            {
                System.out.println("The number you guessed is too low.");
                chance++;
            }
        }

        if (num != ran) 
        {
            System.out.println("Sorry, the number you guessed is wrong. The correct number was " + ran);
        }
    }
}
import java.util.Scanner;

class WordThread implements Runnable {
    private String paragraph;

    WordThread(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void run() {
        try {
            String[] words = paragraph.split("\\s+");
            System.out.println("\n--- Word Thread Output ---");
            for (String word : words) {
                System.out.println(word);
                Thread.sleep(2000); // 2-second delay
            }
        } catch (InterruptedException e) {
            System.out.println("Word Thread Interrupted");
        }
    }
}

class VowelThread implements Runnable {
    private String paragraph;

    VowelThread(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void run() {
        try {
            System.out.println("\n--- Vowel Thread Output ---");
            for (char ch : paragraph.toCharArray()) {
                if ("AEIOUaeiou".indexOf(ch) != -1) {
                    System.out.println(ch);
                    Thread.sleep(2000); // 2-second delay
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Vowel Thread Interrupted");
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph of text:");
        String paragraph = sc.nextLine();

        Thread wordThread = new Thread(new WordThread(paragraph), "word");
        Thread vowelThread = new Thread(new VowelThread(paragraph), "vowel");

        wordThread.start();
        vowelThread.start();

        sc.close();
    }
}

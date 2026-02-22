import java.util.Scanner;

class EvenThread extends Thread {
    int[] numbers;

    EvenThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        System.out.println("\n--- Even Thread Output ---");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.println(num);
                try {
                    Thread.sleep(2000); // 2-second delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

class OddThread extends Thread {
    int[] numbers;

    OddThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        System.out.println("\n--- Odd Thread Output ---");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.println(num);
                try {
                    Thread.sleep(2000); // 2-second delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }

        EvenThread evenThread = new EvenThread(numbers);
        OddThread oddThread = new OddThread(numbers);

        evenThread.start();
        oddThread.start();
    }
}

import java.util.Scanner;

class TableThread extends Thread {
    private int num;

    public TableThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("\n--- Table Thread Output ---");
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
                Thread.sleep(2000); // 2 seconds delay
            }
        } catch (InterruptedException e) {
            System.out.println("Table thread interrupted");
        }
    }
}

class DivisorThread extends Thread {
    private int num;

    public DivisorThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("\n--- Divisor Thread Output ---");
        try {
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.println(i);
                    Thread.sleep(2000); // 2 seconds delay
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Divisor thread interrupted");
        }
    }
}

public class ThreadExample3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        TableThread table = new TableThread(num);
        DivisorThread divisor = new DivisorThread(num);

        table.start();
        divisor.start();
    }
}

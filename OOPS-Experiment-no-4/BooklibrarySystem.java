import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private boolean isIssued;

    public Book(int bookID, String title, String author, double price, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.isIssued = false;
    }

    public void issueBook() {
        if (!isIssued && quantity > 0) {
            isIssued = true;
            quantity -= 1;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book cannot be issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            quantity += 1;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }

    public void displayDetails() {
        System.out.println("Book ID     : " + bookID);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Price       : " + price);
        System.out.println("Quantity    : " + quantity);
        System.out.println("Status      : " + (isIssued ? "Issued" : "Available"));
        System.out.println();
    }
}

public class BooklibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();

        Book book = new Book(id, title, author, price, qty);

        book.displayDetails();

        book.issueBook();
        book.displayDetails();

        book.returnBook();
        book.displayDetails();
    }
}

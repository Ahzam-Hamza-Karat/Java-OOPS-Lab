import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileMenuOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== File Menu Operations ===");
            System.out.println("1. Create a new file");
            System.out.println("2. Rename a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Create a directory");
            System.out.println("5. Find the absolute path of a file");
            System.out.println("6. Display all file names of a particular directory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file name to create: ");
                    String createName = sc.nextLine();
                    File newFile = new File(createName);
                    try {
                        if (newFile.createNewFile())
                            System.out.println("File created successfully: " + newFile.getName());
                        else
                            System.out.println("File already exists.");
                    } catch (IOException e) {
                        System.out.println("Error occurred while creating file.");
                    }
                    break;

                case 2:
                    System.out.print("Enter current file name: ");
                    String oldName = sc.nextLine();
                    System.out.print("Enter new file name: ");
                    String newName = sc.nextLine();
                    File oldFile = new File(oldName);
                    File renamedFile = new File(newName);
                    if (oldFile.renameTo(renamedFile))
                        System.out.println("File renamed successfully.");
                    else
                        System.out.println("Failed to rename the file.");
                    break;

                case 3:
                    System.out.print("Enter file name to delete: ");
                    String deleteName = sc.nextLine();
                    File delFile = new File(deleteName);
                    if (delFile.delete())
                        System.out.println("File deleted successfully.");
                    else
                        System.out.println("Failed to delete file or file not found.");
                    break;

                case 4:
                    System.out.print("Enter directory name to create: ");
                    String dirName = sc.nextLine();
                    File newDir = new File(dirName);
                    if (newDir.mkdir())
                        System.out.println("Directory created successfully.");
                    else
                        System.out.println("Failed to create directory (might already exist).");
                    break;

                case 5:
                    System.out.print("Enter file name to find absolute path: ");
                    String pathFile = sc.nextLine();
                    File absFile = new File(pathFile);
                    System.out.println("Absolute Path: " + absFile.getAbsolutePath());
                    break;

                case 6:
                    System.out.print("Enter directory path to list files: ");
                    String directoryPath = sc.nextLine();
                    File dir = new File(directoryPath);
                    if (dir.isDirectory()) {
                        String[] files = dir.list();
                        System.out.println("Files in directory:");
                        for (String file : files)
                            System.out.println(file);
                    } else {
                        System.out.println("Invalid directory path.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}

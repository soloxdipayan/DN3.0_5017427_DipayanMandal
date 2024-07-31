import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner input = new Scanner(System.in);
        int choice, id;
        String title, author, student;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by ID");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. List All Books");
            System.out.println("7. Delete Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    id = input.nextInt();
                    input.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    title = input.nextLine();
                    System.out.print("Enter book author: ");
                    author = input.nextLine();
                    lib.addBook(id, title, author);
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    id = input.nextInt();
                    lib.searchBookById(id);
                    break;
                case 3:
                    input.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    title = input.nextLine();
                    lib.searchBookByTitle(title);
                    break;
                case 4:
                    System.out.print("Enter book ID: ");
                    id = input.nextInt();
                    input.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    student = input.nextLine();
                    lib.issueBook(id, student);
                    break;
                case 5:
                    System.out.print("Enter book ID: ");
                    id = input.nextInt();
                    lib.returnBook(id);
                    break;
                case 6:
                    lib.listAllBooks();
                    break;
                case 7:
                    System.out.print("Enter book ID: ");
                    id = input.nextInt();
                    lib.deleteBook(id);
                    break;
                case 8:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        input.close();
    }
}
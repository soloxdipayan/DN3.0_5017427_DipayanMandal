import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {
     private ArrayList<Book> books = new ArrayList<>();

    private int findBookIndexById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }

    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
    }

    public void searchBookById(int id) {
        int index = findBookIndexById(id);
        if (index != -1) {
            displayBookDetails(books.get(index));
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                displayBookDetails(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void issueBook(int id, String student) {
        int index = findBookIndexById(id);
        if (index != -1 && !books.get(index).isIssued) {
            books.get(index).isIssued = true;
            System.out.println("Book issued to " + student + ".");
        } else {
            System.out.println("Book is either not found or already issued.");
        }
    }

    public void returnBook(int id) {
        int index = findBookIndexById(id);
        if (index != -1 && books.get(index).isIssued) {
            books.get(index).isIssued = false;
            System.out.println("Book returned.");
        } else {
            System.out.println("Book is either not found or wasn't issued.");
        }
    }

    public void listAllBooks() {
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book a, Book b) {
                return a.title.compareTo(b.title);
            }
        });

        for (Book book : books) {
            displayBookDetails(book);
        }
    }

    public void deleteBook(int id) {
        int index = findBookIndexById(id);
        if (index != -1) {
            books.remove(index);
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBookDetails(Book book) {
        System.out.println("ID: " + book.id + ", Title: " + book.title +
                           ", Author: " + book.author +
                           ", Status: " + (book.isIssued ? "Issued" : "Available"));
    }
}

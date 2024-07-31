public class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int bookId, String bookTitle, String bookAuthor) {
        this.id = bookId;
        this.title = bookTitle;
        this.author = bookAuthor;
        this.isIssued = false;
    }
    
}

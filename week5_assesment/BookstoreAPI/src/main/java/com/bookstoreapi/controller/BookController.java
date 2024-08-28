package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // GET: Retrieve all books
    @GetMapping
    @ResponseStatus(HttpStatus.OK) // Customize status code to 200 OK
    public ResponseEntity<List<Book>> getAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "GetAllBooksHeader");
        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }

    // POST: Add a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Customize status code to 201 Created
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookCreatedHeader");
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    // PUT: Update an existing book
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // Customize status code to 200 OK
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                HttpHeaders headers = new HttpHeaders();
                headers.add("Custom-Header", "BookUpdatedHeader");
                return new ResponseEntity<>(book, headers, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found if the book doesn't exist
    }

     @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> book = books.stream().filter(b -> b.getId().equals(id)).findFirst();
        if (book.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "BookFoundHeader");
            return new ResponseEntity<>(book.get(), headers, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Book not found with ID: " + id);
        }
    }

    // DELETE: Remove a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (!removed) {
            throw new ResourceNotFoundException("Book not found with ID: " + id);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookDeletedHeader");
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
}

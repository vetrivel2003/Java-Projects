package com.library_management.demo.library.Controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.library_management.demo.library.Model.Book;
import com.library_management.demo.library.Service.BookService;




import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books/")
public class BookController {
	private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Add Book
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(
            @Valid @RequestBody Book book) {

        Book savedBook = bookService.addBook(book);

        return new ResponseEntity<>(
                savedBook,
                HttpStatus.CREATED);
    }

    // Search Book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(
            @PathVariable Long bookId) { 

        Book book = bookService.getBookById(bookId);

        return ResponseEntity.ok(book);
    }
    


    // Update Availability
    @PutMapping("/{bookId}/availability")
    public ResponseEntity<Book> updateAvailability(
            @PathVariable Long bookId,
            @RequestParam boolean available) {

        Book book = bookService.updateAvailability(
                bookId, available);

        return ResponseEntity.ok(book);
    }

    // Delete Book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(
            @PathVariable Long bookId) {

        String message = bookService.deleteBook(bookId);

        return ResponseEntity.ok(message);
    }

}

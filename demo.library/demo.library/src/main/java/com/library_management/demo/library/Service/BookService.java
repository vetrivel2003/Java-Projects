package com.library_management.demo.library.Service;

import org.springframework.stereotype.Service;

import com.library_management.demo.library.Exception.BookNotFoundException;
import com.library_management.demo.library.Model.Book;
import com.library_management.demo.library.Repository.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add Book
    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    // Search Book by ID
    public Book getBookById(Long bookId) {

        return bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with ID: " + bookId));
    }

    // Update Availability
    public Book updateAvailability(Long bookId, boolean available) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with ID: " + bookId));

        book.setAvailable(available);

        return bookRepository.save(book);
    }

    // Delete Book
    public String deleteBook(Long bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with ID: " + bookId));

        bookRepository.delete(book);

        return "Book deleted successfully";
    }

}

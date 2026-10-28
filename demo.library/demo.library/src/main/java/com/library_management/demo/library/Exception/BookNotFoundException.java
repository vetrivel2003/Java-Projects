package com.library_management.demo.library.Exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String message) {
        super(message);
    }

}

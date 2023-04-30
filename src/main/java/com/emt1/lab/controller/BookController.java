package com.emt1.lab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emt1.lab.model.Book;
import com.emt1.lab.model.dtos.BookDTO;
import com.emt1.lab.service.BookService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books/add")
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }

    @PostMapping("/books/rent/{id}")
    public void rentBook(@PathVariable("id") Long bookId) {
        bookService.rentBook(bookId);
    }

}

package com.emt1.lab.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;

import com.emt1.lab.model.Book;
import com.emt1.lab.model.dtos.BookDTO;
import com.emt1.lab.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        return null;
    }

    public void addBook(BookDTO bookDto) {
        Book newBook = new Book(bookDto.getName(), bookDto.getCategory(), bookDto.getAvailableCopies());

        bookRepository.saveAndFlush(newBook);

    }

    public void rentBook(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();

            if (book.getAvailableCopies() > 0) {
                book.setAvailableCopies(book.getAvailableCopies() - 1);
                bookRepository.saveAndFlush(book);
            }
        }
    }

}

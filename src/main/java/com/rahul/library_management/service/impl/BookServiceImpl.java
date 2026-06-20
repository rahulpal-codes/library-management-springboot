package com.rahul.library_management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rahul.library_management.entity.Book;
import com.rahul.library_management.exception.ResourceNotFoundException;
import com.rahul.library_management.repository.BookRepository;
import com.rahul.library_management.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new RuntimeException("Book with ISBN '" + book.getIsbn() + "' already exists");
        }
        book.setAvailableCopies(book.getTotalCopies());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Book updateBook(Long id, Book updated) {
        Book book = getBookById(id);
        book.setTitle(updated.getTitle());
        book.setAuthor(updated.getAuthor());
        book.setIsbn(updated.getIsbn());
        int diff = updated.getTotalCopies() - book.getTotalCopies();
        book.setTotalCopies(updated.getTotalCopies());
        book.setAvailableCopies(book.getAvailableCopies() + diff);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }
}
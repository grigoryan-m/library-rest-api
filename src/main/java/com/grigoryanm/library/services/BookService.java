package com.grigoryanm.library.services;

import com.grigoryanm.library.models.Book;
import com.grigoryanm.library.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Book findByIsbn(Long isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public boolean addBook(Book book){
        return bookRepository.save(book).getId() != null;
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public boolean changeStatus(Long id, String status){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            book.get().setStatus(status);
            bookRepository.save(book.get());

            return true;
        }
        return false;
    }

    public boolean updateBook(Long id, Book book){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            bookOptional.get().setTitle(book.getTitle());
            bookOptional.get().setAuthor(book.getAuthor());
            bookOptional.get().setIsbn(book.getIsbn());
            bookRepository.save(bookOptional.get());
            return true;
        }
        return false;
    }
}

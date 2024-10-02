package com.grigoryanm.library.controllers;

import com.grigoryanm.library.models.Book;
import com.grigoryanm.library.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id){
        return bookService.findById(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.findByAuthor(author);
    }

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable Long isbn){
        return bookService.findByIsbn(isbn);
    }
}

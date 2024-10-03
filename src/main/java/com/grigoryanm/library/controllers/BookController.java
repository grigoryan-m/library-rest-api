package com.grigoryanm.library.controllers;

import com.grigoryanm.library.models.Book;
import com.grigoryanm.library.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Finding
    
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.findByTitle(title);
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
    
    // Adding and deleting
    
    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        return String.valueOf(bookService.addBook(book));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return "Successfully deleted the book";
    }

    // Updating

    @PatchMapping("/patch/{id}")
    public Boolean changeStatus(@PathVariable Long id, @RequestParam String status){
        return bookService.changeStatus(id, status);
    }

    @PutMapping("/update/{id}")
    public Boolean updateBook(@PathVariable long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="https://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

@PostMapping
public Book addBook(@RequestBody Book book) {
    return bookService.addBook(book);
}

@GetMapping("/{id")
public Book getBookById(@PathVariable Long id){
    return bookService.getBookById(id);
}

@PutMapping("/id")
public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    return bookService.updateBook(id, book);
}

@DeleteMapping("/{id}")
public void deleteBook(@PathVariable Long id){
    bookService.deleteBook(id);
}
}
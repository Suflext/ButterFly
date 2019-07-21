package ru.library.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/app")
    public Book books() {
        return bookService.getBookById();
    }

    @RequestMapping("/app1")
    public List<Book> book() {
        return bookService.getBookSetById();
    }

}

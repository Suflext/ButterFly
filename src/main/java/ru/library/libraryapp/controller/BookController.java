package ru.library.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public Book add(@RequestParam("name") String name,
                    @RequestParam("description") String description,
                    @RequestParam("published") String published,
                    @RequestParam("year") int year) {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        book.setPublished(published);
        book.setYear(year);
        return bookService.add(book);
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") int id) {
        bookService.delete(id);
    }

    @RequestMapping(value = "/book/find/{id}", method = RequestMethod.GET)
    public Book find(@PathVariable("id") int id) {
        return bookService.findById(id);
    }

    @RequestMapping("/book/findAll")
    public List<Book> findAll() {
        return bookService.getAll();
    }
}

package ru.library.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.library.libraryapp.entity.AuthorTransfer;
import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.entity.BookTransfer;
import ru.library.libraryapp.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public BookTransfer add(@RequestParam("name") String name,
                    @RequestParam("description") String description,
                    @RequestParam("published") String published,
                    @RequestParam("year") int year,
                    @RequestParam("authorId") int authorId) {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        book.setPublished(published);
        book.setYear(year);
        return bookService.add(book, authorId);
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable("id") int id) {
        bookService.delete(id);
    }

    @RequestMapping("/book/findAll")
    public List<BookTransfer> getAll() {
        return bookService.getAll();
    }

    @RequestMapping(value = "/book/find/{id}", method = RequestMethod.GET)
    public BookTransfer getById(@PathVariable("id") int id) {
        return bookService.getById(id);
    }

    @RequestMapping(value = "/book/findAS/{id}", method = RequestMethod.GET)
    public List<AuthorTransfer> getAuthorSetById(@PathVariable("id") int id) {
        return bookService.getAuthorSetById(id);
    }
}

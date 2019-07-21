package ru.library.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.entity.AuthorTransfer;
import ru.library.libraryapp.entity.BookTransfer;
import ru.library.libraryapp.service.AuthorService;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public AuthorTransfer add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastNaem,
                      @RequestParam("year") int year) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastNaem);
        author.setYear(year);
        return authorService.add(author);
    }

    @RequestMapping(value = "/author/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable("id") int id) {
        authorService.delete(id);
    }

    @RequestMapping("/author/findAll")
    public List<AuthorTransfer> getAll() {
        return authorService.getAll();
    }

    @RequestMapping(value = "/author/find/{id}", method = RequestMethod.GET)
    public AuthorTransfer getById(@PathVariable("id") int id) {
        return authorService.getById(id);
    }

    @RequestMapping(value = "/author/findAS/{id}", method = RequestMethod.GET)
    public List<BookTransfer> getBookSetById(@PathVariable("id") int id) {
        return authorService.getBookSetById(id);
    }
}

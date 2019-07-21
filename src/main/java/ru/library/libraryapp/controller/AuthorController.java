package ru.library.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.service.AuthorService;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public Author add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastNaem,
                      @RequestParam("year") int year) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastNaem);
        author.setYear(year);
        return authorService.add(author);
    }

    @RequestMapping(value = "/author/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") int id) {
        authorService.delete(id);
    }

    @RequestMapping(value = "/author/find/{id}", method = RequestMethod.GET)
    public Author find(@PathVariable("id") int id) {
        return authorService.findById(id);
    }

    @RequestMapping("/author/findAll")
    public List<Author> findAll() {
        return authorService.getAll();
    }
}

package ru.library.libraryapp.service;

import org.springframework.stereotype.Service;
import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book add(Book book) {
        bookRepo.save(book);
        return findByName(book.getName());
    }

    private Book findByName(String name){
        return bookRepo.findByName(name);
    }

    public void delete(int id){
        bookRepo.deleteById(id);
    }

    public List<Book> getAll(){
        List<Book> authors = bookRepo.findAll();
        for (Book item : authors)
            item.setAuthorSet(null);
        return authors;
    }

    public Book findById(int id) {
        Book author = bookRepo.findById(id);
        author.setAuthorSet(null);
        return author;
    }

}

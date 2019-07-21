package ru.library.libraryapp.service;

import org.springframework.stereotype.Service;
import ru.library.libraryapp.dto.impl.AuthorDtoImpl;
import ru.library.libraryapp.dto.impl.BookDtoImpl;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.entity.AuthorTransfer;
import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.entity.BookTransfer;
import ru.library.libraryapp.repository.BookRepository;

import java.util.ArrayList;
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

    public List<BookTransfer> getAll(){
        return new BookDtoImpl(new BookTransfer()).convert(bookRepo.findAll());

    }

    public BookTransfer getById(int id) {
        return new BookDtoImpl(new BookTransfer()).convert(bookRepo.findById(id));
    }

    public List<AuthorTransfer> getAuthorSetById(int id) {
        return new AuthorDtoImpl(new AuthorTransfer()).convert(new ArrayList<>(bookRepo.findById(id).getAuthorSet()));
    }
}

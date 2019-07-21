package ru.library.libraryapp.service;

import org.springframework.stereotype.Service;
import ru.library.libraryapp.dto.impl.AuthorDtoImpl;
import ru.library.libraryapp.dto.impl.BookDtoImpl;
import ru.library.libraryapp.entity.AuthorTransfer;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.entity.BookTransfer;
import ru.library.libraryapp.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepo;

    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author add(Author author) {
        authorRepo.save(author);
        return findByFirstName(author.getFirstName());
    }

    private Author findByFirstName(String name) {
        return authorRepo.findByFirstName(name);
    }

    public void delete(int id) {
        authorRepo.deleteById(id);
    }

    public List<AuthorTransfer> getAll() {
        return new AuthorDtoImpl(new AuthorTransfer()).convert(authorRepo.findAll());
    }

    public AuthorTransfer getById(int id) {
        return new AuthorDtoImpl(new AuthorTransfer()).convert(authorRepo.findById(id));
    }

    public List<BookTransfer> getBookSetById(int id) {
        return new BookDtoImpl(new BookTransfer()).convert(new ArrayList<>(authorRepo.findById(id).getBookSet()));
    }
}

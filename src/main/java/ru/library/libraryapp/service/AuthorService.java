package ru.library.libraryapp.service;

import org.springframework.stereotype.Service;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.repository.AuthorRepository;

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

    private Author findByFirstName(String name){
        return authorRepo.findByFirstName(name);
    }

    public void delete(int id){
        authorRepo.deleteById(id);
    }

    public List<Author> getAll(){
        List<Author> authors = authorRepo.findAll();
        for (Author item : authors)
            item.setBookSet(null);
        return authors;
    }

    public Author findById(int id) {
        Author author = authorRepo.findById(id);
        author.setBookSet(null);
        return author;
    }
}

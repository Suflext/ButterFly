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

    public List<Author> getAuthorSetById() {
        //return authorRepo.findBookAuthorSetByBookId(225);
        return authorRepo.getAuthorSetById();
    }

    public Author findFirstNameById() {
        Author author = authorRepo.findFirstNameById(193L);
        author.setBookSet(null);

        /*Query q = em.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a");
        List<Object[]> authors = q.getResultList();

        for (Object[] a : authors) {
            System.out.println("Author "
                    + a[0]
                    + " "
                    + a[1]);
        }*/

        return author;
    }
}

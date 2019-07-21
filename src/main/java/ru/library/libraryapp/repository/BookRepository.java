package ru.library.libraryapp.repository;

import ru.library.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long id);

    Book findByName(String FirstName);

    void deleteById(long id);

}

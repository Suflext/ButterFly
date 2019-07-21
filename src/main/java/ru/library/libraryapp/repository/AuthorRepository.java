package ru.library.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.library.libraryapp.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findById(long id);

    Author findByFirstName(String FirstName);

    void deleteById(long id);
}

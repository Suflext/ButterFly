package ru.library.libraryapp.dto;

import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.entity.AuthorTransfer;

import java.util.List;

public interface AuthorDto {
    AuthorTransfer convert(Author author);

    List<AuthorTransfer> convert(List<Author> authors);
}

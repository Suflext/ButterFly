package ru.library.libraryapp.dto.impl;

import ru.library.libraryapp.dto.AuthorDto;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.entity.AuthorTransfer;

import java.util.ArrayList;
import java.util.List;

public class AuthorDtoImpl implements AuthorDto {

    private AuthorTransfer authorTransfer;

    public AuthorDtoImpl(AuthorTransfer authorTransfer) {
        this.authorTransfer = authorTransfer;
    }

    @Override
    public List<AuthorTransfer> convert(List<Author> authors) {
        List<AuthorTransfer> authorTransfers = new ArrayList<>();
        for (Author author: authors){
            authorTransfer = new AuthorTransfer();
            authorTransfers.add(convert(author));
        }
        return authorTransfers;
    }

    @Override
    public AuthorTransfer convert(Author author) {
        authorTransfer.setId(author.getId());
        authorTransfer.setFirstName(author.getFirstName());
        authorTransfer.setLastName(author.getLastName());
        authorTransfer.setYear(author.getYear());
        return authorTransfer;
    }
}

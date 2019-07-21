package ru.library.libraryapp.dto;

import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.entity.BookTransfer;

import java.util.List;

public interface BookDto {
    BookTransfer convert(Book book);

    List<BookTransfer> convert(List<Book> books);
}

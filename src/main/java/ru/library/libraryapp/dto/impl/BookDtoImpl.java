package ru.library.libraryapp.dto.impl;

import ru.library.libraryapp.dto.BookDto;
import ru.library.libraryapp.entity.Book;
import ru.library.libraryapp.entity.BookTransfer;

import java.util.ArrayList;
import java.util.List;

public class BookDtoImpl implements BookDto {

    private BookTransfer bookTransfer;

    public BookDtoImpl(BookTransfer bookTransfer) {
        this.bookTransfer = bookTransfer;
    }

    @Override
    public BookTransfer convert(Book book) {
        bookTransfer.setId(book.getId());
        bookTransfer.setName(book.getName());
        bookTransfer.setDescription(book.getDescription());
        bookTransfer.setPublished(book.getPublished());
        bookTransfer.setYear(book.getYear());
        return bookTransfer;
    }

    @Override
    public List<BookTransfer> convert(List<Book> books) {
        List<BookTransfer> bookTransfers = new ArrayList<>();
        for (Book book: books){
            bookTransfer = new BookTransfer();
            bookTransfer.setId(book.getId());
            bookTransfer.setName(book.getName());
            bookTransfer.setDescription(book.getDescription());
            bookTransfer.setPublished(book.getPublished());
            bookTransfer.setYear(book.getYear());
            bookTransfers.add(bookTransfer);
        }
        return bookTransfers;
    }
}

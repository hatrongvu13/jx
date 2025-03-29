package com.xxx.jx.controller;

import com.xxx.jx.data.dto.Book;
import com.xxx.jx.data.entity.BookEntity;
import com.xxx.jx.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElse(null);
        if (bookEntity == null) {
            return Optional.empty();
        }
        return Optional.of(new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor()));
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String author) {
        BookEntity book = new BookEntity();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.save(book);
        return new Book(book.getId(), book.getTitle(), book.getAuthor());
    }

}

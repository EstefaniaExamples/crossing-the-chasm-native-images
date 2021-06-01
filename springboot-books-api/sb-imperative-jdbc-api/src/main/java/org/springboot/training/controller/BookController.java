package org.springboot.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.training.model.Book;
import org.springboot.training.model.BookAuthorDto;
import org.springboot.training.persistence.BookRepository;
import org.springboot.training.service.BookAuthorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class BookController {
    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;
    private final BookAuthorsService bookAuthorsService;

    public BookController(final BookRepository bookRepository, final BookAuthorsService bookAuthorsService) {
        this.bookRepository = bookRepository;
        this.bookAuthorsService = bookAuthorsService;
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toUnmodifiableList()));
    }

    @GetMapping(value = "/native/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookAuthorDto>> getAllBookNative() {
        LOG.info("Getting all books using native query ...");
        return ResponseEntity.ok().body(bookAuthorsService.findAll());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        final Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(optionalBook.get());
        }
    }

    @GetMapping("/native/books/{id}")
    public ResponseEntity<BookAuthorDto> getNativeBookById(@PathVariable Long id) {
        final BookAuthorDto bookAuthorDto = bookAuthorsService.findBookById(id);
        if (bookAuthorDto == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(bookAuthorDto);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveNewBook(@RequestBody Book book) {
        final Book bookSaved = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookSaved);
    }
}

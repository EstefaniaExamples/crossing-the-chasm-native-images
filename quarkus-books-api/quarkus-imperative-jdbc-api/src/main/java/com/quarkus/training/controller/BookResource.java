package com.quarkus.training.controller;

import com.quarkus.training.model.Book;
import com.quarkus.training.service.BookService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/native/books")
public class BookResource {
    private final BookService bookService;

    public BookResource(final BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book bookById(@PathParam("id") Long id) {
        return bookService.getBookById(id);
    }
}
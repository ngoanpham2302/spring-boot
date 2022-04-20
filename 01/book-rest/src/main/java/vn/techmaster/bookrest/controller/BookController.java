package vn.techmaster.bookrest.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.bookrest.dto.BookRequest;
import vn.techmaster.bookrest.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("RONOVEL111", new Book("RONOVEL111", "A walk to remember", "Nicholas Sparks", 1999));
        books.put("RONOVEL112", new Book("RONOVEL112", "If only it were true", "Marc Levy", 2000));
        books.put("RONOVEL113", new Book("RONOVEL113", "Lost and Found", "Guillaume Musso", 2007));
    }

    // Get all books
    @GetMapping
    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    // Add new book
    @PostMapping
    public Book addNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book newBook = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newBook);
        return newBook;
    }

    // Get book by id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") String id) {
        return books.get(id);
    }

    // Update book by id
    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable("id") String id, @RequestBody BookRequest bookRequest) {
        Book updatedBook = new Book(id, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(id, updatedBook);
        return updatedBook;
    }

    // Delete book by id
    @DeleteMapping("/{id}")
    public Book deleteBookById(@PathVariable("id") String id) {
        Book removedBook = books.remove(id);
        return removedBook;
    }
}

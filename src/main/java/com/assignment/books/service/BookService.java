package com.assignment.books.service;

import com.assignment.books.domain.request.ReqBook;
import com.assignment.books.domain.request.ReqBookPartial;
import com.assignment.books.domain.response.ResBook;
import com.assignment.books.entity.BookEntity;
import com.assignment.books.exception.DataNotFoundException;
import com.assignment.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public ResBook createBook(ReqBook request) {
        BookEntity book = new BookEntity();

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublishedDate(request.getPublishedDate());

        return mapBookEntityToResBook(bookRepository.save(book));
    }

    public List<ResBook> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public ResBook getBookById(Long id) {
        return mapBookEntityToResBook(findBookById(id));
    }

    public ResBook updateBook(Long id, ReqBook request) {
        BookEntity book = findBookById(id);

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublishedDate(request.getPublishedDate());

        return mapBookEntityToResBook(bookRepository.save(book));
    }

    public ResBook partialUpdateBook(Long id, ReqBookPartial request) {
        BookEntity book = findBookById(id);

        if (request.getTitle() != null && !request.getTitle().isBlank()) {
            book.setTitle(request.getTitle());
        }

        if (request.getAuthor() != null && !request.getAuthor().isBlank()) {
            book.setAuthor(request.getAuthor());
        }

        if (request.getIsbn() != null && !request.getIsbn().isBlank()) {
            book.setIsbn(request.getIsbn());
        }

        if (request.getPublishedDate() != null) {
            book.setPublishedDate(request.getPublishedDate());
        }

        return mapBookEntityToResBook(bookRepository.save(book));
    }

    private BookEntity findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
            new DataNotFoundException("book"));
    }

    private ResBook mapBookEntityToResBook(BookEntity bookEntity) {
        return new ResBook(
            bookEntity.getId(),
            bookEntity.getTitle(),
            bookEntity.getAuthor(),
            bookEntity.getIsbn(),
            bookEntity.getPublishedDate()
        );
    }
}

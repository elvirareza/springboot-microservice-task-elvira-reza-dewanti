package com.assignment.books.service;

import com.assignment.books.domain.request.ReqBook;
import com.assignment.books.domain.response.ResBook;
import com.assignment.books.entity.BookEntity;
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

package com.assignment.books.repository;

import com.assignment.books.domain.response.ResBook;
import com.assignment.books.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("""
        SELECT new com.assignment.books.domain.response.ResBook(
            b.id, b.title, b.author, b.isbn, b.publishedDate
        ) FROM BookEntity b
        ORDER BY b.id
    """)
    List<ResBook> findAllBooks();
}

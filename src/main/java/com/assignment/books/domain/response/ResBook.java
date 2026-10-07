package com.assignment.books.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ResBook {
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private LocalDate publishedDate;
}

package com.assignment.books.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqBookPartial {
    private String title;

    private String author;

    private String isbn;

    private LocalDate publishedDate;
}

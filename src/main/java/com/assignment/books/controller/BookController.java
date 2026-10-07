package com.assignment.books.controller;


import com.assignment.books.domain.request.ReqBook;
import com.assignment.books.domain.response.BaseResponse;
import com.assignment.books.domain.response.ResBook;
import com.assignment.books.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BaseResponse<ResBook>> createItem(
        @Valid @RequestBody ReqBook request
    ) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(BaseResponse.success(bookService.createBook(request)));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<ResBook>>> getAllBooks() {
        return ResponseEntity.ok(BaseResponse.success(bookService.getAllBooks()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ResBook>> getBookById(
        @PathVariable Long id
    ) {
        return ResponseEntity.ok(BaseResponse.success(bookService.getBookById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<ResBook>> updateBook(
        @PathVariable Long id,
        @Valid @RequestBody ReqBook request
    ) {
        return ResponseEntity.ok(BaseResponse.success(bookService.updateBook(id, request)));
    }
}

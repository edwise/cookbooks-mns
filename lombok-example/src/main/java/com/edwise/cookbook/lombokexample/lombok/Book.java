package com.edwise.cookbook.lombokexample.lombok;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Book {
    private long id;
    private String isbn;
    private String name;
    private String authorName;
    private LocalDate releaseDate;
}

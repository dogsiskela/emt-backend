package com.emt1.lab.model.dtos;

import com.emt1.lab.model.enumerations.BookCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String name;
    private BookCategory category;
    private Integer availableCopies;
}

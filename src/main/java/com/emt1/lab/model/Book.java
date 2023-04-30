package com.emt1.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.emt1.lab.model.enumerations.BookCategory;

import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BookCategory category;
    private Integer availableCopies;

    public Book(){
        
    }

    public Book(String name, BookCategory category, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}

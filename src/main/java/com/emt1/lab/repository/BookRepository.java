package com.emt1.lab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emt1.lab.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

package com.library_management.demo.library.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library_management.demo.library.Model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
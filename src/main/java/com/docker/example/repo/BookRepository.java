package com.docker.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.example.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
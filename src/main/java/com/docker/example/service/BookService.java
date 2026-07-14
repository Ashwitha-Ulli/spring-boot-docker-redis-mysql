package com.docker.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.docker.example.entity.Book;
import com.docker.example.repo.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Cacheable(value = "books", key = "#id")
    public Book getBookById(Long id) {
        System.out.println("Fetching from DB (not cache): " + id);
        return bookRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "books", key = "#id")
    public void clearCache(Long id) {
        System.out.println("Cache cleared for id: " + id);
    }
}
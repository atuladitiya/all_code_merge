package com.spring.docker.book.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.docker.book.entity.Book;

public interface BookRepository extends MongoRepository<Book,Integer> {

}

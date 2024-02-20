package com.spring.docker.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.docker.book.dao.BookRepository;
import com.spring.docker.book.entity.Book;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import java.util.List;  // Add this import statement

@SpringBootApplication
@RestController
@RequestMapping("/book")
@EnableDiscoveryClient
public class BookCollectionApplication {

    @Autowired
    private BookRepository repo;

   @PostMapping("/save")
   public Book saveBook(@RequestBody Book book) {
	   return repo.save(book);
   }
    @GetMapping("/get")
    public List<Book> getAll() {
        return repo.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookCollectionApplication.class, args);
    }
}

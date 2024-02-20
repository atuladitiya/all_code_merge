package com.spring.docker.book.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="books")
public class Book {
private int bookId;
private String bookName;
private String authorName;
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
@Override
public String toString() {
	return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + "]";
}
public Book(int bookId, String bookName, String authorName) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.authorName = authorName;
}
public Book() {
	super();
	}

}

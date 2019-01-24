package com.sunil.springData.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sunil.springData.service.LocalDatePersistenceConverter;



@Entity
@Table(name = "books_7")
public class Book  implements java.io.Serializable {

	private static final long serialVersionUID = 8188625640812813899L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "bookId")
long bookId;
@Column(name = "title")
String title; 
@Column(name = "price")
double price;
@Column(name = "volume")
Integer volume;
@Column(name = "publishDate")
@Convert(converter = LocalDatePersistenceConverter.class)
LocalDate publishDate;
@Transient
String date;


public static long getSerialversionuid() {
	return serialVersionUID;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public void setBookId(long bookId) {
	this.bookId = bookId;
}

public Book() {
}

public Book(long bookId, String title, double price,Integer volume, LocalDate date) {
	this.bookId = bookId;
	this.title = title;
	this.price= price;
	this.publishDate=date;
	this.volume = volume;
}
public Book(long bookId, String title, double price,Integer volume, String date) {
	this.bookId = bookId;
	this.title = title;
	this.price= price;
	this.date=date;
	this.volume = volume;
}

public long getBookId() {
	return bookId;
}
public void setBookId(int id) {
	this.bookId= id ;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Integer getVolume() {
	return volume;
}
public void setVolume(Integer volume) {
	this.volume = volume;
}
public LocalDate getPublishDate() {
	return publishDate;
}
public void setPublishDate(LocalDate publishDate) {
	this.publishDate = publishDate;
}
@Override
public String toString() {
	return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume + ", publishDate="
			+ publishDate + "]";
}

}

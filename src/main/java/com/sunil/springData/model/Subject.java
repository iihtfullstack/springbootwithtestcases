package com.sunil.springData.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "subjects_7")
public class Subject implements Serializable {

	private static final long serialVersionUID = -7790713935470658837L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject")
	  long subject;
	@Column(name = "subTitle")
	String subTitle;
	@Column(name = "durationInHours")
	int durationInHours;
	@Column(name = "bookId")
	long bookId;
	
	@Transient
String refIds;
	
	public Subject(long subject, String subTitle, int durationInHours, String refIds) {
		this.subject = subject;
		this.subTitle = subTitle;
		this.durationInHours = durationInHours;
		this.refIds = refIds;
	}
	
	public Subject() {};
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRefIds() {
		return refIds;
	}
	public void setRefIds(String refIds) {
		this.refIds = refIds;
	}
	@OneToMany(targetEntity = Book.class, cascade = javax.persistence.CascadeType.ALL,fetch = FetchType.EAGER)
	
	Set<Book> references;
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public void setSubject(long subject) {
		this.subject = subject;
	}
	
	public long getSubject() {
		return subject;
	}
	public void setSubject(int id) {
		this.subject=id;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Set<Book> getReferences() {
		return references;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}
	@Override
	public String toString() {
		return "Subject [subject=" + subject + ", subTitle=" + subTitle + ", durationInHours=" + durationInHours
				+ ", references=" + references + "]";
	}


}

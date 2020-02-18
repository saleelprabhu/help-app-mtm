package com.jd.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

/*
	Keywords entity will hold all the keywords for the contents
	Join table is created to handle Many-to-many relationship of Contents and Keywords
*/

@Entity
@Table(name = "keywords")
public class Keyword {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(unique = true)
	private String keyword;
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "keywords")
	private Set<KnowledgeBase> contents = new HashSet<>();

// Constructor
	public Keyword() {
		System.out.println("Keyword - Default Constructor");
	}

// Getter - Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Set<KnowledgeBase> getContents() { 
		return contents; 
	}
	
	public void setContents(Set<KnowledgeBase> contents) { 
		this.contents =	contents;
	}

// Overridden Methods
	@Override
	public String toString() {
		return "Keyword [id = " + id + ", keyword = " + keyword + ", contents = " + contents + "]";
	}
}
package com.jd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

/*
	Contents entity will hold the contents and the keywords to identify the content for search.
	Join table is created to handle Many-to-many relationship of Contents and Keywords 
*/

@Entity
@Table(name = "contents")
public class KnowledgeBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String title;
	@NotNull
	private String content;
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "contents_keywords", joinColumns = {@JoinColumn(name = "contents_id")}, inverseJoinColumns = {@JoinColumn(name = "keywords_id") })
	private Set<Keyword> keywords = new HashSet<>();
	
// Constructor
	public KnowledgeBase() {
		System.out.println("Knowledge Base - Default Constructor");
	}

// Getter - Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}


// Overridden Methods
	@Override
	public String toString() {
		return "KnowledgeBase [id=" + id + ", title=" + title + ", content=" + content + ", keywords=" + keywords + "]";
	}		
}
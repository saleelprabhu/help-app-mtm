package com.jd.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jd.model.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Integer> {

/*
	To be used for add new content
*/

	Keyword findByKeyword(String key);
}
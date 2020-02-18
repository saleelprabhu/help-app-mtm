package com.jd.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jd.model.KnowledgeBase;

@Repository
public interface HelpRepository extends JpaRepository<KnowledgeBase, Integer> {

}
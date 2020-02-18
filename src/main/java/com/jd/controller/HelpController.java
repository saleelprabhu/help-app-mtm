package com.jd.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jd.model.KnowledgeBase;
import com.jd.service.HelpService;

@RequestMapping(path = "/webapp")
@EnableJpaRepositories(basePackages = "com.jd.data")
@CrossOrigin
@RestController
public class HelpController {
	
	@Autowired
	private HelpService service;
	
	@GetMapping(path = "/contents")
	public Set<KnowledgeBase> getSearchDetails(@RequestParam(name = "search") String searchString) {
		return service.getSearchResult(searchString);
	}
}
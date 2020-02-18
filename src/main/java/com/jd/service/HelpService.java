package com.jd.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.data.HelpRepository;
import com.jd.model.Keyword;
import com.jd.model.KnowledgeBase;

@Service
public class HelpService {

	@Autowired
	private HelpRepository repo;
	
/*
	Get Search Result with search string
	First get all keywords for the content
	Check for keyword in search-text and return - check for each available content
	
	- For consistency keyword and search-text is converted to lower-case before checks
	- Keywords from KnowledgeBase are cleared before adding to list.
		Reason being, both have reference to each other's entity, resulting in infinite loop.
		Clearing keywords stopped the reference and hence the loop.
*/

	public Set<KnowledgeBase> getSearchResult(String searchText) {
		
		Set<KnowledgeBase> result = new HashSet<KnowledgeBase>();

		repo.findAll().forEach(content -> {
			Set<Keyword> strKeys = content.getKeywords();

			for(Keyword key : strKeys) {
				String text = searchText.trim().toLowerCase();
				String str = key.getKeyword().trim().toLowerCase();
				
				if(text.contains(str)) {
					content.getKeywords().clear();
					result.add(content);
					break;
				}
			}
		});
		
		return result;
	}
}
package com.hackathon.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.hackathon.quarkus.entity.Blog;
import com.hackathon.quarkus.repository.BlogRepository;

@ApplicationScoped
public class BlogServiceImpl {

	@Inject
	private BlogRepository blogRepository;
	
	
	public List<Blog> fetchAllBlogs() {
		return blogRepository.listAll();
	}
}

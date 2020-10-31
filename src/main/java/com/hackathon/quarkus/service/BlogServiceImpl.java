package com.hackathon.quarkus.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.hackathon.quarkus.entity.Blog;
import com.hackathon.quarkus.repository.BlogRepository;
import com.hackathon.quarkus.vo.BlogVO;

@ApplicationScoped
public class BlogServiceImpl {

	@Inject
	private BlogRepository blogRepository;
	
	
	public List<BlogVO> fetchAllBlogs() {
		List<BlogVO> blogVos = new ArrayList<>();
		List<Blog> blogs= blogRepository.listAll();
		for(Blog blog: blogs){
			BlogVO blogVO = setBlogVO(blog);
			blogVos.add(blogVO);
		}
		return blogVos;
	}
	
	private BlogVO setBlogVO(Blog blog) {
		BlogVO blogVO = new BlogVO();
		blogVO.setAuthor(blog.getAuthor());
		if(null != blog.getBlogId()){
			blogVO.setId(blog.getBlogId().toString());
		}
		blogVO.setHeader(blog.getHeading());
		blogVO.setBody(blog.getContent());
		blogVO.setTimestamp(blog.getLastUpdate());
		return blogVO;
	}
	
	private Blog setBlog(BlogVO blogVO) {
		Blog blog = new Blog();
		blog.setAuthor(blogVO.getAuthor());
		blog.setContent(blogVO.getBody());
		blog.setHeading(blogVO.getHeader());
		blog.setLastUpdate(blogVO.getTimestamp());
		return blog;
	}

	public BlogVO saveBlog(BlogVO blogVO) {
		Blog blog = setBlog(blogVO);
		blog.persist();
		return setBlogVO(blog);
	}

	public Boolean deleteBlog(BlogVO blog) {
		try {
			Blog.deleteById(blog.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public BlogVO editBlog(BlogVO blogVO) {
		Blog blog = Blog.findById(blogVO.getId());
		if(null!= blog){
			blog.setContent(blogVO.getBody());
			blog.setHeading(blogVO.getHeader());
			blog.setLastUpdate(LocalDate.now().toString());
			blog.persistOrUpdate();
		}
		return setBlogVO(blog);
	}
}

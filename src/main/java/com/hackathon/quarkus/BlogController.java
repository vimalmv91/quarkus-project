package com.hackathon.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hackathon.quarkus.service.BlogServiceImpl;
import com.hackathon.quarkus.vo.BlogVO;

@Path("/blog")
@Consumes("application/json")
@Produces("application/json")
public class BlogController {
	
	@Inject
	BlogServiceImpl blogServiceImpl;
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
    @GET
    @Path("/blog")
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("/getBlogDetails")
    public List<BlogVO> fetchAllBlogs() {
    	LOG.error("Blog"); 
        return blogServiceImpl.fetchAllBlogs();
    }
    
    @POST
    @Path("/editBlog")
	BlogVO editBlog(BlogVO blogVO) {
		LOG.debug("Edit Blog");
		return blogServiceImpl.editBlog(blogVO);
	}
	
    @POST
    @Path("/saveBlog")
	BlogVO saveBlog(BlogVO blogVO) {
		LOG.debug("Save Blog");
		return blogServiceImpl.saveBlog(blogVO);
	}
	
    @POST
    @Path("/deleteBlog")
	Boolean deleteBlog(BlogVO blog) {
		LOG.debug("Delete Blog");
		return blogServiceImpl.deleteBlog(blog);
	}
}

package com.hackathon.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackathon.quarkus.entity.Blog;
import com.hackathon.quarkus.service.BlogServiceImpl;

@Path("/")
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
    @Path("/blogs")
    public List<Blog> fetchAllBlogs() {
    	LOG.error("Blog"); 
        return blogServiceImpl.fetchAllBlogs();
    }
    
}

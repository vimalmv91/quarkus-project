package com.hackathon.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackathon.quarkus.entity.User;
import com.hackathon.quarkus.service.UserServiceImpl;

@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public class UserController {

	@Inject
	UserServiceImpl userServiceImpl;
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
    @GET
    @Path("/hello")
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("/getUserDetails")
    public List<User> fetchAllUsers() {
        return userServiceImpl.fetchAllUsers();
    }
    
    @POST
    @Path("/registerUser")
    public Response create(User user) {
        user.persist();
        return Response.status(200).build();
    }
    
    @POST
    @Path("/login")
    public boolean login(User user) {
    	LOG.error("herere");
		return userServiceImpl.login(user);
	}
}
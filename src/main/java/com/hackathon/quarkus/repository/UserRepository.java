package com.hackathon.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.hackathon.quarkus.entity.User;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

	public User findByUserEmailId(String emailId) {
		return find("emailId",emailId).firstResult();
    }

}

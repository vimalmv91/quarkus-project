package com.hackathon.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.hackathon.quarkus.entity.Blog;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class BlogRepository implements PanacheMongoRepository<Blog>{

}

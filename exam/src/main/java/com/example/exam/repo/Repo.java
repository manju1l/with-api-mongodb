package com.example.exam.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.exam.model.Model;

public interface Repo extends MongoRepository<Model, Integer> {

}

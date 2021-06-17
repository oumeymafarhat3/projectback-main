package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Document;

public interface DocumentRepository extends CrudRepository<Document, Integer> {

}

package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {

}

package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Message;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.MessageRepository;

@RestController
public class MessageController {
@Autowired
MessageRepository messageRepository;
@GetMapping("message")
public List<Message> afficheUsers()
{
	
return 	(List<Message>) messageRepository.findAll();

}
@PostMapping("message")
public Message adduser( @RequestBody Message message)
{
	return messageRepository.save(message);

}

//Get a Single Utilisateur
@GetMapping("/message/{id}")
public Message getUtilisateurById(@PathVariable(value = "id") Integer id) {
 return messageRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));
}

@DeleteMapping("/message/{id}")
public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Integer id) {
    Message message = messageRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));

    messageRepository.delete(message);

    return ResponseEntity.ok().build();
}



}
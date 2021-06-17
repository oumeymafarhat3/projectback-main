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

import com.example.demo.entities.Document;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.DocumentRepository;

@RestController
public class DocumentController {
@Autowired
DocumentRepository documentRepository;
@GetMapping("document")
public List<Document> afficheUsers()
{
	
return 	(List<Document>) documentRepository.findAll();

}
@PostMapping("document")
public Document adduser( @RequestBody Document document)
{
	return documentRepository.save(document);

}

//Get a Single Utilisateur
@GetMapping("/document/{id}")
public Document getUtilisateurById(@PathVariable(value = "id") Integer id) {
 return documentRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));
}

@DeleteMapping("/document/{id}")
public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") Integer id) {
    Document document = documentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));

    documentRepository.delete(document);

    return ResponseEntity.ok().build();
}



}
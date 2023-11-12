package org.evolsw.elastic.controller.rest;

import org.evolsw.elastic.controller.data.VDocumentDTO;
import org.evolsw.elastic.controller.services.DocumentService;
import org.evolsw.elastic.controller.services.ElasticIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    ElasticIndexService elasticIndexService;

    @PostMapping("/document")
    ResponseEntity<String> addDocument(@RequestBody VDocumentDTO document) {

        if (elasticIndexService.isIndexNotCreated()) {
            return new ResponseEntity<>("Index not created", HttpStatus.BAD_REQUEST);
        }
        documentService.addDocument(document);
        return new ResponseEntity<>("New document added: " + document.getId(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<String> getDocument(@PathVariable String id) {

        if (elasticIndexService.isIndexNotCreated()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        VDocumentDTO document = documentService.getDocument(id);
        if (document == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(document.getContent(), HttpStatus.OK);
    }

}

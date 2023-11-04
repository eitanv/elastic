package org.evolsw.elastic.controller.rest;

import org.evolsw.elastic.controller.data.VDocument;
import org.evolsw.elastic.controller.services.DocumentService;
import org.evolsw.elastic.controller.services.ElasticIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    ElasticIndexService elasticIndexService;

    @PostMapping("/index")
    ResponseEntity<String> createIndex() {
        elasticIndexService.createIndex();
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

    @PostMapping("/document")
    ResponseEntity<String> addDocument(@RequestBody VDocument document) {

        if (elasticIndexService.isIndexNotCreated())
        {
            return new ResponseEntity<>("Index not created", HttpStatus.BAD_REQUEST);
        }
        documentService.addDocument(document);
        return new ResponseEntity<>(document.getId(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<VDocument> getDocument(@PathVariable String id) {

        if (elasticIndexService.isIndexNotCreated())
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Optional<VDocument> document = documentService.getDocument(id);
        return document.map(vDocument -> new ResponseEntity<>(vDocument, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.OK));
    }

    @PostMapping("/index/delete")
    ResponseEntity<String> deleteIndex() {
        elasticIndexService.deleteIndex();
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}

package org.evolsw.elastic.controller.rest;

import org.evolsw.elastic.controller.services.ElasticIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    ElasticIndexService elasticIndexService;

    @PostMapping("/")
    ResponseEntity<String> createIndex() {
        elasticIndexService.createIndex();
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

    @DeleteMapping("/")
    ResponseEntity<String> deleteIndex() {
        elasticIndexService.deleteIndex();
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}

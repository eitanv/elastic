package org.evolsw.elastic.controller.services.implementation;

import lombok.AllArgsConstructor;
import org.evolsw.elastic.controller.data.VDocument;
import org.evolsw.elastic.controller.services.DocumentService;
import org.evolsw.elastic.model.jpa.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository repository;

    @Override
    public void addDocument(VDocument doc) {
        repository.save(doc);
        return;
    }

    @Override
    public Optional<VDocument> getDocument(String id) {

        return repository.findById(id);
    }

}

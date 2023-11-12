package org.evolsw.elastic.controller.services.implementation;

import lombok.AllArgsConstructor;
import org.evolsw.elastic.controller.data.VDocumentDTO;
import org.evolsw.elastic.controller.mappers.VDocumentMapper;
import org.evolsw.elastic.controller.services.DocumentService;
import org.evolsw.elastic.model.VDocument;
import org.evolsw.elastic.model.jpa.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository repository;

    @Autowired
    VDocumentMapper mapper;

    @Override
    public void addDocument(VDocumentDTO doc) {
        repository.save(mapper.map(doc));
    }

    @Override
    public VDocumentDTO getDocument(String id) {

        Optional<VDocument> oVdoc = repository.findById(id);
        return oVdoc.map(doc -> mapper.map(doc)).orElse(null);
    }

}

package org.evolsw.elastic.controller.services;

import org.evolsw.elastic.controller.data.VDocument;

import java.util.Optional;

public interface DocumentService {

    void addDocument(VDocument doc);

    Optional<VDocument> getDocument(String id);
}

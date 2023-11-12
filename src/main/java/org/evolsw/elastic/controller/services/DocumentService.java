package org.evolsw.elastic.controller.services;

import org.evolsw.elastic.controller.data.VDocumentDTO;

public interface DocumentService {

    void addDocument(VDocumentDTO doc);

    VDocumentDTO getDocument(String id);
}

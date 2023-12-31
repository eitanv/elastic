package org.evolsw.elastic.model.jpa;

import org.evolsw.elastic.controller.data.VDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public interface DocumentRepository extends ElasticsearchRepository<VDocument, String> {
}

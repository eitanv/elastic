package org.evolsw.elastic.controller.services.implementation;

import org.evolsw.elastic.controller.services.ElasticIndexService;
import org.evolsw.elastic.model.VDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.stereotype.Service;


@Service
public class ElasticIndexServiceImpl implements ElasticIndexService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    private Boolean isIndexCreated = false;

    @Override
    public void createIndex() {

        if (isIndexCreated)
            return;
        IndexOperations indexOperations = elasticsearchOperations.indexOps(VDocument.class);
        synchronized (this) {
            indexOperations.delete();
            indexOperations.create();
            isIndexCreated = true;
        }
    }

    public boolean isIndexNotCreated() {
        return !isIndexCreated;
    }

    @Override
    public void deleteIndex() {
        IndexOperations indexOperations = elasticsearchOperations.indexOps(VDocument.class);
        synchronized (this) {
            indexOperations.delete();
            isIndexCreated = false;
        }

    }
}

package org.evolsw.elastic.controller.services.implementation;

import org.evolsw.elastic.controller.data.VDocument;
import org.evolsw.elastic.controller.services.ElasticIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.stereotype.Service;


@Service
public class ElasticIndexServiceImpl implements ElasticIndexService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    private boolean isIndexCreated = false;

    @Override
    public void createIndex() {

        IndexOperations indexOperations = elasticsearchOperations.indexOps(VDocument.class);
        if (isIndexCreated)
            return;
        indexOperations.delete();
        indexOperations.create();
        isIndexCreated = true;
    }

    public boolean isIndexNotCreated() {
        return !isIndexCreated;
    }
}

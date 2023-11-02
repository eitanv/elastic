package org.evolsw.elastic.controller.services;

public interface ElasticIndexService {
    void createIndex();

    boolean isIndexNotCreated();
}

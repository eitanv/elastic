package org.evolsw.elastic.controller.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "vicarius", createIndex = false)
public class VDocument {

    @Id
    String id;
    @Field(type = FieldType.Text, name = "content")
    String content;
}

package org.evolsw.elastic.controller.mappers;

import org.evolsw.elastic.controller.data.VDocumentDTO;
import org.evolsw.elastic.model.VDocument;

public interface VDocumentMapper {

    VDocument map(VDocumentDTO vDocumentDTO);

    VDocumentDTO map(VDocument vDocument);

}

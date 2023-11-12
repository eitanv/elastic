package org.evolsw.elastic.controller.mappers.implementation;

import org.evolsw.elastic.controller.data.VDocumentDTO;
import org.evolsw.elastic.controller.mappers.VDocumentMapper;
import org.evolsw.elastic.model.VDocument;
import org.springframework.stereotype.Component;

@Component
public class VDocumentMapperImpl implements VDocumentMapper {
    @Override
    public VDocument map(VDocumentDTO vDocumentDTO) {

        if (vDocumentDTO ==null)
            return null;
        VDocument vDocument = new VDocument();
        vDocument.setId(vDocumentDTO.getId());
        vDocument.setContent(vDocumentDTO.getContent());
        return vDocument;
    }

    @Override
    public VDocumentDTO map(VDocument vDocument) {

        if (vDocument==null)
            return null;
        VDocumentDTO vDocumentDTO = new VDocumentDTO();
        vDocumentDTO.setId(vDocument.getId());
        vDocumentDTO.setContent(vDocument.getContent());
        return vDocumentDTO;
    }
}

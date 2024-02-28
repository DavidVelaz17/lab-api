package com.lab.labeli.convertors;

import com.lab.labeli.entity.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConvertor implements AttributeConverter<Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status status) {
        if(status==null) {
            return null;
        }
        return status.getKey();
    }

    @Override
    public Status convertToEntityAttribute(Integer key) {
        if(key==null) {
            return null;
        }
        return Status.getStatus(key);
    }
}

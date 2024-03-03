package com.lab.labeli.convertors;

import com.lab.labeli.entity.Tests;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TestsConvertor implements AttributeConverter<Tests, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Tests tests) {
        if(tests==null) {
            return null;
        }
        return tests.getKey();
    }

    @Override
    public Tests convertToEntityAttribute(Integer key) {
        if(key==null) {
            return null;
        }
        return Tests.getTests(key);
    }
}

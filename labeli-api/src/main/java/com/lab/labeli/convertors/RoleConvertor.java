package com.lab.labeli.convertors;

import com.lab.labeli.entity.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RoleConvertor implements AttributeConverter<Role, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Role role) {
        if(role==null) {
            return null;
        }
        return role.getKey();
    }

    @Override
    public Role convertToEntityAttribute(Integer key) {
        if(key==null) {
            return null;
        }
        return Role.getRole(key);
    }
}

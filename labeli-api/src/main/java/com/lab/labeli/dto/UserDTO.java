package com.lab.labeli.dto;

import com.lab.labeli.entity.Role;
import com.lab.labeli.entity.User;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

@Getter
@Builder
public class UserDTO {
    @ApiObjectField(name = "idUser", description = "User's ID")
    private int idUser;

    @ApiObjectField(name = "name", description = "User's name")
    private String name;

    @ApiObjectField(name = "age", description = "User's age")
    private int age;

    @ApiObjectField(name = "phoneNumber", description = "User's phone number")
    private String phoneNumber;

    @ApiObjectField(name = "address", description = "User's address")
    private String address;

    @ApiObjectField(name = "password", description = "User's password")
    private String password;

    @ApiObjectField(name = "role", description = "User's role")
    private Role role;

    public static UserDTO build(final User user){
        return UserDTO.builder()
                .idUser(user.getIdUser())
                .name(user.getName())
                .age(user.getAge())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .role(user.getRole())
                .build();
    }
}

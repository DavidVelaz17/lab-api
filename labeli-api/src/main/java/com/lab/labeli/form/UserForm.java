package com.lab.labeli.form;

import com.lab.labeli.entity.Role;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    @ApiObjectField(name= "name", description = "User's name")
    @Size(max = 100,message = "{right.length}")
    private String name;

    @ApiObjectField(name= "age", description = "Users's age")
    @Size (max = 3,message = "{right.length}")
    private int age;

    @ApiObjectField(name = "phoneNumber", description = "Users's phone number")
    @Size(max = 13, message = "{phoneNumber.right.length}")
    private String phoneNumber;

    @ApiObjectField(name= "address", description = "User's address")
    @Size (max = 200,message = "{right.length}")
    private String address;

    @ApiObjectField(name = "password", description = "User's password")
    @Size(max = 100, message = "{name.right.length}")
    private String password;

    @ApiObjectField(name = "role", description = "User's role")
    private Role role;
}

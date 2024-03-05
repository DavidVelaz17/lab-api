package com.lab.labeli.entity;

import com.lab.labeli.convertors.RoleConvertor;
import com.lab.labeli.form.UserForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusers",nullable = false,unique = true)
    private int idUser;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Convert(converter = RoleConvertor.class)
    private Role role;

    public User(final UserForm form){
        this.name=form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.password=form.getPassword();
        this.role=form.getRole();
    }
    public void updateUser(final UserForm form){
        this.name=form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.password=form.getPassword();
        this.role=form.getRole();
    }
}

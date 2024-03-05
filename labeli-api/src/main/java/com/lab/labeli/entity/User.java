package com.lab.labeli.entity;

import com.lab.labeli.convertors.RoleConvertor;
import com.lab.labeli.form.UserForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails{

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
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

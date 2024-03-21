package com.lab.labeli.entity;

import com.lab.labeli.convertors.RoleConvertor;
import com.lab.labeli.form.UserForm;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusers",nullable = false,unique = true)
    private int idUser;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_age", nullable = false)
    private int age;

    @Column(name = "user_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_address", nullable = false)
    private String address;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_role", nullable = false)
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
    public void updateUser(final User user){
        this.name=user.getName();
        this.age=user.getAge();
        this.phoneNumber=user.getPhoneNumber();
        this.address=user.getAddress();
        this.password=user.getPassword();
        this.role=user.getRole();
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

package com.lab.labeli.services;

import com.lab.labeli.dto.UserDTO;
import com.lab.labeli.entity.Customer;
import com.lab.labeli.entity.User;
import com.lab.labeli.form.UserForm;
import com.lab.labeli.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        final List<User> getAll = userRepository.findAll();
        return getAll.stream().map(UserDTO::build).toList();
    }

    public UserDTO getUserById(final int idUser) {
        final User user = userRepository.findById(idUser).get();
        return UserDTO.build(user);
    }

    public UserDTO getUserByName(final String userName) {
        final User user = userRepository.findByName(userName);
        return UserDTO.build(user);
    }

    public void deleteUser(final int idUser) {
        userRepository.deleteById(idUser);
    }


    public UserDTO createUser(final UserForm form) {
        User user = User.builder()
                .name(form.getName())
                .age(form.getAge())
                .phoneNumber(form.getPhoneNumber())
                .address(form.getAddress())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(form.getRole())
                .build();

        userRepository.save(user);
        return UserDTO.build(user);
    }


    public UserDTO updateUser(final UserForm form, final int idUser) {
        final User user = userRepository.findById(idUser).get();
        user.updateUser(form);
        userRepository.save(user);
        return UserDTO.build(user);
    }

//    public UserDTO updateUser(final UserForm form, final int idUser) {
//        final User userUpdate = userRepository.findById(idUser).get();
//
//        User userInfo = User.builder()
//                .name(form.getName())
//                .age(form.getAge())
//                .phoneNumber(form.getPhoneNumber())
//                .address(form.getAddress())
//                .role(form.getRole())
//                .build();
//
//        userUpdate.updateUser(userInfo);
//        userRepository.save(userUpdate);
//        return UserDTO.build(userUpdate);
//    }
}

package com.lab.labeli.services;

import com.lab.labeli.dto.CustomerDTO;
import com.lab.labeli.dto.UserDTO;
import com.lab.labeli.entity.Customer;
import com.lab.labeli.entity.User;
import com.lab.labeli.form.UserForm;
import com.lab.labeli.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${not.found}")
    private String notFound;

    public List<UserDTO> getAllUsers() {
        final List<User> getAll = userRepository.findAll();
        return getAll
                .stream()
                .map(UserDTO::build)
                .sorted(Comparator.comparing(UserDTO::getIdUser).reversed())
                .toList();
    }

    public UserDTO getUserById(final int idUser) throws Exception {
        validateIfUserExists(idUser);
        final User user = userRepository.findById(idUser).get();
        return UserDTO.build(user);
    }

    public UserDTO getUserByName(final String userName) {
        final User user = userRepository.findByName(userName);
        return UserDTO.build(user);
    }

    public void deleteUser(final int idUser) throws Exception {
        validateIfUserExists(idUser);
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

    public UserDTO updateUser(final UserForm form, final int idUser) throws Exception {
        validateIfUserExists(idUser);
        final User userUpdate = userRepository.findById(idUser).get();

        User userInfo = User.builder()
                .name(form.getName())
                .age(form.getAge())
                .phoneNumber(form.getPhoneNumber())
                .password(passwordEncoder.encode(form.getPassword()))
                .address(form.getAddress())
                .role(form.getRole())
                .build();

        userUpdate.updateUser(userInfo);
        userRepository.save(userUpdate);
        return UserDTO.build(userUpdate);
    }

    private void validateIfUserExists(final int idUser) throws Exception{
        if(!userRepository.existsById(idUser)){
            throw new Exception(notFound);
        }
    }

    public Map<Integer, UserDTO> getUsersByIds(final List<Integer> usersIds) {
        final List<User> users = userRepository.findAllById(usersIds);
        return usersDTOs(users);
    }

    private Map<Integer, UserDTO> usersDTOs(final List<User> users){
        final List<UserDTO> userDTOs = users.stream().map(UserDTO::build).toList();
        return userDTOs.stream().collect(Collectors.toMap(UserDTO::getIdUser, Function.identity()));
    }
}

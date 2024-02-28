package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.CustomerDTO;
import com.lab.labeli.dto.UserDTO;
import com.lab.labeli.form.UserForm;
import com.lab.labeli.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/lab/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        final List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") final int userId){
        final UserDTO userDTOInfo = userService.getUserById(userId);
        return ResponseEntity.ok().body(userDTOInfo);
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid final UserForm form){
        final UserDTO saveUserInfo = userService.createUser(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUserInfo);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") final int userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid final UserForm form, @PathVariable("userId") final int userId){
        final UserDTO updateUserInfo = userService.updateUser(form,userId);
        return ResponseEntity.ok().body(updateUserInfo);
    }
}

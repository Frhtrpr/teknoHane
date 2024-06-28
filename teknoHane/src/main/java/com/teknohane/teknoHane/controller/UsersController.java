package com.teknohane.teknoHane.controller;

import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.UsersDTO;
import com.teknohane.teknoHane.model.mapper.UsersMapper;
import com.teknohane.teknoHane.security.JwtUtil;
import com.teknohane.teknoHane.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class UsersController {

    private final UsersService userService;
    private  JwtUtil jwtUtil;

    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/get")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        List<UsersDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/users/get/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Long id) {
        UsersDTO user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@RequestBody UsersDTO userDTO) {
        if (userService.isEpostaUnique(userDTO.getEposta())) {
            userDTO.setRole("USER_ROLE");
            UsersDTO createdUser = userService.createUser(userDTO);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("E-posta adresi zaten kullanılıyor.", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/api/users/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UsersDTO userDTO) {
        UsersDTO existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return new ResponseEntity<>("Kullanıcı bulunamadı.", HttpStatus.NOT_FOUND);
        }

        if (userDTO.getEposta() != null) {
            existingUser.setEposta(userDTO.getEposta());
        }
        if (userDTO.getPhone() != null) {
            existingUser.setPhone(userDTO.getPhone());
        }
        if (userDTO.getGender() != null) {
            existingUser.setGender(userDTO.getGender());
        }

        UsersDTO updatedUser = userService.updateUser(id, existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping("/users/resetPassword/{eposta}")
    public ResponseEntity<String> resetUserPassword(@PathVariable String eposta, @RequestParam String newPassword) {
        boolean resetSuccess = userService.resetUserPassword(eposta, newPassword);
        if (resetSuccess) {
            return new ResponseEntity<>("Password reset successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with given email not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/users/resetEmail/{id}")
    public ResponseEntity<?> resetUserEmail(@PathVariable Long id, @RequestParam String newEmail) {
        UsersDTO resetEmailUser = userService.getUserById(id);
        if (resetEmailUser == null) {
            return new ResponseEntity<>("Kullanıcı bulunamadı.", HttpStatus.NOT_FOUND);
        }
        if (!userService.isEpostaUnique(newEmail)) {
            return new ResponseEntity<>("E-posta adresi zaten kullanılıyor.", HttpStatus.CONFLICT);
        }
        resetEmailUser.setEposta(newEmail);

        UsersDTO updatedUser = userService.updateUser(id, resetEmailUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }



    @DeleteMapping("/api/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>("Deleted " + id, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/users/getUserInfo")
    public ResponseEntity<UsersDTO> getUserInfo(Authentication authentication) {

            UsersDTO userInfo = userService.getUserByUsername(authentication.getName());
            if (userInfo != null) {
                return new ResponseEntity<>(userInfo, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }

}

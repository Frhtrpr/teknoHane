package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.dto.UsersDTO;

import java.util.List;
import java.util.UUID;

public interface UsersService {

    boolean resetUserPassword(String eposta, String newPassword);
    List<UsersDTO> getAllUsers();
    UsersDTO getUserById(Long id);
    UsersDTO createUser(UsersDTO userDTO);
    UsersDTO updateUser(Long id, UsersDTO userDTO);
    boolean deleteUser(Long id);
    public boolean isEpostaUnique(String eposta);
    UsersDTO getUserByUsername(String username);
}

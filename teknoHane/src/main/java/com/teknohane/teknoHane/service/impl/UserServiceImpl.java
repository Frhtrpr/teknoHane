package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.UsersDTO;
import com.teknohane.teknoHane.repository.UsersRepository;
import com.teknohane.teknoHane.model.mapper.UsersMapper;
import com.teknohane.teknoHane.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public boolean isEpostaUnique(String eposta) {
        Optional<Users> user = usersRepository.findByEposta(eposta);
        return !user.isPresent();
    }

    @Override
    public boolean resetUserPassword(String eposta, String newPassword) {
        Optional<Users> optionalUser = usersRepository.findByEposta(eposta);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            usersRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(UsersMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDTO getUserById(Long id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        return optionalUser.map(UsersMapper::toDTO).orElse(null);
    }

    @Override
    public UsersDTO createUser(UsersDTO userDTO) {
        Users user = UsersMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user = usersRepository.save(user);
        return UsersMapper.toDTO(user);
    }

    @Override
    public UsersDTO updateUser(Long id, UsersDTO userDTO) {
        if (!usersRepository.existsById(id)) {
            return null;
        }
        Users userToUpdate = UsersMapper.toEntity(userDTO);
        userToUpdate.setId(id);
        userToUpdate = usersRepository.save(userToUpdate);
        return UsersMapper.toDTO(userToUpdate);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!usersRepository.existsById(id)) {
            return false;
        }
        usersRepository.deleteById(id);
        return true;
    }

    @Override
    public UsersDTO getUserByUsername(String teknoHaneToken) {
        Optional<Users> optionalUser = usersRepository.findByEposta(teknoHaneToken);
        return optionalUser.map(UsersMapper::toDTO).orElse(null);
    }

}

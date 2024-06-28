package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    // Users sınıfından UsersDTO'ya dönüşümü gerçekleştirir.
    public static UsersDTO toDTO(Users user) {
        UsersDTO dto = new UsersDTO();
        dto.setId(user.getId());
        dto.setEposta(user.getEposta());
        dto.setPassword(user.getPassword());
        dto.setPhone(user.getPhone());
        dto.setGender(user.getGender());
        dto.setBirthday(user.getBirthday());
        dto.setRole(user.getRole());
        return dto;
    }
    // UsersDTO'dan Users sınıfına dönüşümü gerçekleştirir.
    public static Users toEntity(UsersDTO dto) {
        Users user = new Users();
        user.setId(dto.getId());
        user.setEposta(dto.getEposta());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setGender(dto.getGender());
        user.setBirthday(dto.getBirthday());
        user.setRole(dto.getRole());
        return user;
    }
}

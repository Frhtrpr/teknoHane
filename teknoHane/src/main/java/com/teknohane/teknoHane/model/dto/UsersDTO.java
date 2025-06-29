package com.teknohane.teknoHane.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UsersDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String eposta;
    private String password;
    private String phone;
    private String gender;
    private Date birthday;
    private String role;
}

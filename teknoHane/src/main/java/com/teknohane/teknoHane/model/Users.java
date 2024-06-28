package com.teknohane.teknoHane.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "eposta")
    private String eposta;
    @Getter
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "role")
    private String role;


    @Override
    public String getUsername() {
        return this.eposta;
    }

    /* @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
     }*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    // Kullanıcı hesabının süresinin dolup dolmadığını .
    // her zaman true döndürülüyor, yani hesap sürekli geçerli .
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // Kullanıcının hesabının kilitlenip kilitlenmediğini belirten metod.
    // her zaman true , yani hesap sürekli açık .
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // Kullanıcının kimlik doğrulama bilgilerinin  süresinin dolup dolmadığını .
    // her zaman true , yani kimlik doğrulama bilgileri sürekli geçerli .
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    // Kullanıcının etkinleştirilip etkinleştirilmediğini .
    // her zaman true , yani kullanıcı hesabı her zaman etkin durumda .
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", eposta='" + eposta + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
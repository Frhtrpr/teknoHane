package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long> {
    Optional<Users> findByEposta(String eposta);

}

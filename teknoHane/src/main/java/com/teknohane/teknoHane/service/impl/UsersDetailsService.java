package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    /**
     * @param eposta
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String eposta) throws UsernameNotFoundException {
        return (UserDetails) usersRepository.findByEposta(eposta).orElseThrow(() -> new UsernameNotFoundException(String.format("%s eposta not found", eposta)));
    }
}

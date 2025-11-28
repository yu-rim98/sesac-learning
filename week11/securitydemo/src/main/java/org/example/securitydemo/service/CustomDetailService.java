package org.example.securitydemo.service;

import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import org.example.securitydemo.entity.User;
import org.example.securitydemo.repository.UserRepository;
import org.example.securitydemo.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomDetailService implements UserDetailsService, Serializable {

    private static final long serialVersionUID = 1L;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(username));
        return new CustomUserDetails(user);
    }
}

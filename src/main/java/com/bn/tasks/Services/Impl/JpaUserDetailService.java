package com.bn.tasks.Services.Impl;

import com.bn.tasks.Repositories.UserRepository;
import com.bn.tasks.exceptions.NotFoundException;
import com.bn.tasks.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUserNameOrEmail(username, username);
        return user.map(SecurityUser::new).orElseThrow(()->new NotFoundException("Username not " + username + "found!"));
    }
}

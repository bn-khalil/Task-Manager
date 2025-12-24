package com.bn.tasks.Services.Impl;

import com.bn.tasks.Repositories.UserRepository;
import com.bn.tasks.Services.AuthService;
import com.bn.tasks.dto.AuthenticationResponse;
import com.bn.tasks.dto.UserLoginDto;
import com.bn.tasks.dto.UserRegisterDto;
import com.bn.tasks.entities.User;
import com.bn.tasks.security.SecurityUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(
            UserRepository userRepository,
            JwtService jwtService,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder(12);
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse login(UserLoginDto userLoginDto) {
        Authentication auth = this.authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(userLoginDto.userNameOrEmail(), userLoginDto.password())
        );

        

        return null;
    }

    @Override
    public AuthenticationResponse register(UserRegisterDto userRegisterDto) {
        System.out.println(userRegisterDto);
        User user = new User();
        user.setUserName(userRegisterDto.username());
        user.setEmail(userRegisterDto.email());
        user.setPassword(this.encoder.encode(userRegisterDto.password()));
        user = this.userRepository.save(user);

        String jwtToken = this.jwtService.generateToken(new SecurityUser(user));

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .usrename(user.getUserName())
                .build();
    }
}

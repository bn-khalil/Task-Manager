package com.bn.tasks.Services;

import com.bn.tasks.dto.AuthenticationResponse;
import com.bn.tasks.dto.UserLoginDto;
import com.bn.tasks.dto.UserRegisterDto;

public interface AuthService {
    public AuthenticationResponse login(UserLoginDto userLoginDto);
    public AuthenticationResponse register(UserRegisterDto userRegisterDto);
}

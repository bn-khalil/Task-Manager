package com.bn.tasks.Services;

import com.bn.tasks.dto.UserDto;

public interface UserService {
    UserDto findUserByUserName(String userName);
    UserDto findUserByEmail(String email);
}

package com.bn.tasks.Services;

import com.bn.tasks.dto.UserDto;
import com.bn.tasks.entities.User;

import java.util.UUID;

public interface UserService {
    UserDto findUserByUserName(String userName);
    User createNewUser(User userDto);
    UserDto getUser(UUID user_id);
}

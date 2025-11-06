package com.bn.tasks.Services.Impl;

import com.bn.tasks.Repositories.UserRepository;
import com.bn.tasks.Services.UserService;
import com.bn.tasks.dto.UserDto;
import com.bn.tasks.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto findUser(String userInput) {
        User user = this.userRepository.findByUsernameOrEmail(userInput, userInput);

        return null;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return null;
    }
}

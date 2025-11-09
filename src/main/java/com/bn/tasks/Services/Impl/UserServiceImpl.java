package com.bn.tasks.Services.Impl;

import com.bn.tasks.Repositories.UserRepository;
import com.bn.tasks.Services.UserService;
import com.bn.tasks.dto.UserDto;
import com.bn.tasks.entities.User;
import com.bn.tasks.exceptions.NotFoundException;
import com.bn.tasks.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl (
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto findUserByUserName(String userInput) {
        User user = this.userRepository.findByUserNameOrEmail(userInput, userInput).orElseThrow(
                ()-> new NotFoundException("User Not Found Exception!")
        );
        return this.userMapper.toDto(user);
    }

    @Override
    public User createNewUser(User user) {
        return this.userRepository.save(user);
    }

    public UserDto getUser(UUID user_id) {
        User user = this.userRepository.findById(user_id).orElseThrow(
                ()->new NotFoundException("User Not Found!")
        );
        return this.userMapper.toDto(user);
    }
}

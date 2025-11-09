package com.bn.tasks.mappers.Impl;

import com.bn.tasks.dto.UserDto;
import com.bn.tasks.entities.User;
import com.bn.tasks.mappers.TaskListMapper;
import com.bn.tasks.mappers.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapperImpl implements UserMapper {
    private final TaskListMapper taskListMapper;

    public UserMapperImpl(TaskListMapper taskListMapper) {
        this.taskListMapper = taskListMapper;
    }


/*    @Override
    public User fromDto(UserDto userDto) {
        return new User(
                userDto.Id(),
                userDto.userName(),
                userDto.email()
        );
    }*/

    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                Optional.ofNullable(user.getTaskLists()).map(
                        task_list -> task_list
                                .stream()
                                .map(this.taskListMapper::toDto)
                                .toList())
                        .orElse(null)
        );
    }
}

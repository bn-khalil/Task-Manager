package com.bn.tasks.mappers;

import com.bn.tasks.dto.UserDto;
import com.bn.tasks.entities.User;

public interface UserMapper {
//        User fromDto(UserDto userDto );

        UserDto toDto ( User user );
}

package com.bn.tasks.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record UserDto(
        UUID Id,
        @NotNull(message = "username not exist!")
        @Size(min = 2, max = 50)
        String userName,
        @Email
        @NotNull(message = "email required!")
        String email,
        List<TaskListDto> taskLists
) {}

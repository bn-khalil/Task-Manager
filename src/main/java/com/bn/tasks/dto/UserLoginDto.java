package com.bn.tasks.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserLoginDto(
        @NotEmpty(message = "username or email required!")
        @Size(min = 3, max = 100, message = "username size not valid!")
        String userNameOrEmail,

        @NotEmpty(message = "password required!")
        @Size(min = 8, message = "password length not valid!")
        String password
) {}

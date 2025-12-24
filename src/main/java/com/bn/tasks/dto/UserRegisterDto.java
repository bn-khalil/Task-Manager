package com.bn.tasks.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserRegisterDto(
        @NotEmpty(message = "username required!")
        @Size(min = 3, max = 100, message = "username size not valid!")
        String username,

        @NotEmpty(message = "email required!")
        @Email
        String email,

        @NotEmpty(message = "password required!")
        @Size(min = 8, message = "password length not valid!")
        String password
) {}

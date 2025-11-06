package com.bn.tasks.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserDto(
        UUID Id,
        @NotNull
        @Size(min = 2, max = 50)
        String userName,
        @Email
        @NotNull
        String email
) {}

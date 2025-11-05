package com.bn.tasks.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserDto(UUID Id,
                      String userName )
{}

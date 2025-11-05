package com.bn.tasks.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record TaskListDto(
        UUID id,
        @NotNull String title,
        String description,
        List<TaskDto> tasksDto
) {}

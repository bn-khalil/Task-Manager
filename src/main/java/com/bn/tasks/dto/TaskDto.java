package com.bn.tasks.dto;

import com.bn.tasks.enums.TaskPriority;
import com.bn.tasks.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record TaskDto(UUID id,
                      @NotNull String title,
                      String description,
                      TaskStatus status,
                      TaskPriority priority,
                      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                      @NotNull
                      @FutureOrPresent
                      LocalDateTime dateToStart
) {}

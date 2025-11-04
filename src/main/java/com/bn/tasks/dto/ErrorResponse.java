package com.bn.tasks.dto;

import lombok.Data;

import java.time.LocalDateTime;

public record ErrorResponse(int statusCode,
                            String message,
                            LocalDateTime timestamp
                            ) {}

package com.bn.tasks.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String token,
        String usrename
) {}

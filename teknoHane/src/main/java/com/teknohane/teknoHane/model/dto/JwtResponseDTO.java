package com.teknohane.teknoHane.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtResponseDTO {

    private final String token;
    private String role;
}

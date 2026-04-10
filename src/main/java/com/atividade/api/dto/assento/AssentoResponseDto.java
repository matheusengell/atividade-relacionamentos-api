package com.atividade.api.dto.assento;

public record AssentoResponseDto(
        Long id,
        String codigo,
        Long funcionarioId
) {
}

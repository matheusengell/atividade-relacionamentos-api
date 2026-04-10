package com.atividade.api.dto.assento;

import jakarta.validation.constraints.NotBlank;

public record AssentoRequestDto(

        @NotBlank(message = "O código é obrigatório")
        String codigo
) {
}

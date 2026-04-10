package com.atividade.api.dto.projeto;

import jakarta.validation.constraints.NotBlank;

public record ProjetoRequestDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome
) {
}

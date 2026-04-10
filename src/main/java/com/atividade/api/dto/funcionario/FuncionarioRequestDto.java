package com.atividade.api.dto.funcionario;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioRequestDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome
) {
}

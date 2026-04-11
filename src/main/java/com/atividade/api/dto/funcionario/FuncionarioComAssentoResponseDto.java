package com.atividade.api.dto.funcionario;

import com.atividade.api.dto.assento.AssentoResponseDto;

public record FuncionarioComAssentoResponseDto(
        FuncionarioResponseDto funcionario,
        AssentoResponseDto assento
) {
}

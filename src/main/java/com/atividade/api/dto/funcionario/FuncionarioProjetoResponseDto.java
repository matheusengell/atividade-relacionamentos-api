package com.atividade.api.dto.funcionario;

import com.atividade.api.dto.projeto.ProjetoResponseDto;

import java.util.List;

public record FuncionarioProjetoResponseDto(
        FuncionarioResponseDto funcionario,
        List<ProjetoResponseDto> projetos
) {
}

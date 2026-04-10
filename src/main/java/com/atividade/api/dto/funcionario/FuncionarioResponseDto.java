package com.atividade.api.dto.funcionario;

import com.atividade.api.model.Projeto;

import java.util.List;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        Long assentoId,
        List<Long> projetos
) {


}

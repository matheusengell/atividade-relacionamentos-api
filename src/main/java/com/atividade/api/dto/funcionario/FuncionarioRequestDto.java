package com.atividade.api.dto.funcionario;

import com.atividade.api.dto.assento.AssentoRequestDto;
import com.atividade.api.model.Assento;
import com.atividade.api.model.Projeto;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record FuncionarioRequestDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        Long assentoId,

        List<Long> projetoIds


) {
}

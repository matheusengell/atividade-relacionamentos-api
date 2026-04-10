package com.atividade.api.mapper;

import com.atividade.api.dto.funcionario.FuncionarioRequestDto;
import com.atividade.api.dto.funcionario.FuncionarioResponseDto;
import com.atividade.api.model.Funcionario;
import com.atividade.api.model.Projeto;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {
    public Funcionario paraEntidade(FuncionarioRequestDto requestDto){
        return new Funcionario(
                requestDto.nome()
        );
    }

    public FuncionarioResponseDto paraDto(Funcionario funcionario){
        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getAssento().getId(),
                funcionario.getProjetos().stream()
                        .map(Projeto::getId)
                        .toList()
        );
    }

}

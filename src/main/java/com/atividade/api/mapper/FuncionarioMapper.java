package com.atividade.api.mapper;

import com.atividade.api.dto.assento.AssentoResponseDto;
import com.atividade.api.dto.funcionario.FuncionarioComAssentoResponseDto;
import com.atividade.api.dto.funcionario.FuncionarioProjetoResponseDto;
import com.atividade.api.dto.funcionario.FuncionarioRequestDto;
import com.atividade.api.dto.funcionario.FuncionarioResponseDto;
import com.atividade.api.dto.projeto.ProjetoResponseDto;
import com.atividade.api.model.Funcionario;
import com.atividade.api.model.Projeto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper {
    private final AssentoMapper assentoMapper;
    private final ProjetoMapper projetoMapper;

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

    public FuncionarioComAssentoResponseDto funcionarioComAssentoResponseDto(Funcionario funcionario){
        AssentoResponseDto assentoResponseDto = assentoMapper.paraDto(funcionario.getAssento());

        FuncionarioResponseDto funcionarioResponseDto = paraDto(funcionario);

        return new FuncionarioComAssentoResponseDto(funcionarioResponseDto, assentoResponseDto);
    }

    public FuncionarioProjetoResponseDto funcionarioProjetoResponseDto(Funcionario funcionario){
        List<ProjetoResponseDto> projetos = funcionario.getProjetos()
                .stream()
                .map(projetoMapper::paraDto)
                .toList();

        FuncionarioResponseDto funcionarioResponseDto = paraDto(funcionario);

        return new FuncionarioProjetoResponseDto(funcionarioResponseDto, projetos);
    }


}

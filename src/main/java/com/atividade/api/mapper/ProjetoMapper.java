package com.atividade.api.mapper;

import com.atividade.api.dto.projeto.ProjetoRequestDto;
import com.atividade.api.dto.projeto.ProjetoResponseDto;
import com.atividade.api.model.Projeto;
import org.springframework.stereotype.Component;

@Component
public class ProjetoMapper {

    public Projeto paraEntidade(ProjetoRequestDto requestDto){
        return new Projeto(
                requestDto.nome()
        );
    }

    public ProjetoResponseDto paraDto(Projeto projeto){
        return new ProjetoResponseDto(
                projeto.getId(),
                projeto.getNome()
        );
    }
}

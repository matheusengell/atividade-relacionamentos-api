package com.atividade.api.mapper;

import com.atividade.api.dto.assento.AssentoRequestDto;
import com.atividade.api.dto.assento.AssentoResponseDto;
import com.atividade.api.model.Assento;
import org.springframework.stereotype.Component;

@Component
public class AssentoMapper {

    public Assento paraEntidade(AssentoRequestDto requestDto){
        return new Assento(
                requestDto.codigo()
        );
    }

    public AssentoResponseDto paraDto(Assento assento){
        return new AssentoResponseDto(
                assento.getId(),
                assento.getCodigo()
        );
    }
}

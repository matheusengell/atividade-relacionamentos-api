package com.atividade.api.service;

import com.atividade.api.dto.assento.AssentoRequestDto;
import com.atividade.api.dto.assento.AssentoResponseDto;
import com.atividade.api.mapper.AssentoMapper;
import com.atividade.api.model.Assento;
import com.atividade.api.repository.AssentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssentoService {

    private final AssentoRepository repository;
    private final AssentoMapper mapper;

    public AssentoResponseDto criarAssento(AssentoRequestDto requestDto){
        Assento assento = mapper.paraEntidade(requestDto);
        repository.save(assento);
        return mapper.paraDto(assento);
    }

    public List<AssentoResponseDto> listarTodos(){
        List<Assento> assentos = repository.findAll();

        return assentos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public AssentoResponseDto atualizar(AssentoRequestDto requestDto, Long id){
        Assento assento = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Assento não encontrado"));

        assento.setId(assento.getId());
        assento.setCodigo(assento.getCodigo());
        assento.setFuncionario(assento.getFuncionario());

        Assento novoAssento = repository.save(assento);
        return mapper.paraDto(novoAssento);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}

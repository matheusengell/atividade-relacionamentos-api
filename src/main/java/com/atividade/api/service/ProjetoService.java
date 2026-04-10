package com.atividade.api.service;

import com.atividade.api.dto.projeto.ProjetoRequestDto;
import com.atividade.api.dto.projeto.ProjetoResponseDto;
import com.atividade.api.mapper.ProjetoMapper;
import com.atividade.api.model.Projeto;
import com.atividade.api.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;

    public ProjetoResponseDto criar(ProjetoRequestDto requestDto){
        Projeto projeto = mapper.paraEntidade(requestDto);
        repository.save(projeto);
        return mapper.paraDto(projeto);
    }

    public List<ProjetoResponseDto> listarTodos(){
        List<Projeto> projetos = repository.findAll();

        return projetos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public ProjetoResponseDto atualizar(ProjetoRequestDto requestDto, Long id){
        Projeto projeto = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Projeto não encontrado"));

        projeto.setNome(requestDto.nome());

        return mapper.paraDto(projeto);
    }


    public void deletar(Long id){
        repository.deleteById(id);
    }
}
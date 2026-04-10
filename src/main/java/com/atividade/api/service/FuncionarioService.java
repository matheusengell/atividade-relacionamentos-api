package com.atividade.api.service;

import com.atividade.api.dto.funcionario.FuncionarioRequestDto;
import com.atividade.api.dto.funcionario.FuncionarioResponseDto;
import com.atividade.api.mapper.FuncionarioMapper;
import com.atividade.api.model.Assento;
import com.atividade.api.model.Funcionario;
import com.atividade.api.model.Projeto;
import com.atividade.api.repository.AssentoRepository;
import com.atividade.api.repository.FuncionarioRepository;
import com.atividade.api.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;
    private final ProjetoRepository projetoRepository;
    private final AssentoRepository assentoRepository;

    public FuncionarioResponseDto criar(FuncionarioRequestDto requestDto){
        Assento assento = assentoRepository.findById(requestDto.assentoId())
                .orElseThrow(()-> new RuntimeException("Nenhuma assento encontrado"));

        List<Projeto> projetos = projetoRepository.findAllById(requestDto.projetoIds());
        if (projetos.isEmpty() && !requestDto.projetoIds().isEmpty()){
            throw new RuntimeException("Nenhum projeto encontrado");
        }

        Funcionario funcionario = mapper.paraEntidade(requestDto);

        funcionario.setAssento(assento);
        funcionario.setProjetos(projetos);
        return mapper.paraDto(repository.save(funcionario));
    }

    public List<FuncionarioResponseDto> listarTodos(){
        List<Funcionario> funcionarios = repository.findAll();

        return funcionarios.stream()
                .map(mapper::paraDto)
                .toList();
    }
    public FuncionarioResponseDto atualizar(FuncionarioRequestDto requestDto, Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Assento assento = assentoRepository.findById(requestDto.assentoId())
                .orElseThrow(() -> new RuntimeException("Nenhum assento encontrado"));

        List<Projeto> projetos = projetoRepository.findAllById(requestDto.projetoIds());
        if (projetos.isEmpty() && !requestDto.projetoIds().isEmpty()) {
            throw new RuntimeException("Nenhum projeto encontrado");
        }
        mapper.paraEntidade(requestDto);
        funcionario.setAssento(assento);
        funcionario.setProjetos(projetos);

        return mapper.paraDto(repository.save(funcionario));
    }


    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado para exclusão");
        }
        repository.deleteById(id);
    }



}

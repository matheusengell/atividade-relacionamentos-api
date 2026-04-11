package com.atividade.api.controller;

import com.atividade.api.dto.funcionario.FuncionarioComAssentoResponseDto;
import com.atividade.api.dto.funcionario.FuncionarioProjetoResponseDto;
import com.atividade.api.dto.funcionario.FuncionarioRequestDto;
import com.atividade.api.dto.funcionario.FuncionarioResponseDto;
import com.atividade.api.model.Funcionario;
import com.atividade.api.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> criar(@RequestBody FuncionarioRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listarTodos(){
        List<FuncionarioResponseDto> funcionarios = service.listarTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> atualizar(@RequestBody FuncionarioRequestDto requestDto, @PathVariable Long id){
        FuncionarioResponseDto funcionario = service.atualizar(requestDto, id);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{idFuncionario}/assento/{idAssento}")
    public ResponseEntity<FuncionarioComAssentoResponseDto> associarAssentoFuncionario(@PathVariable Long idFuncionario, @PathVariable Long idAssento){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.associarFuncionarioAssento(idFuncionario, idAssento));
    }
    @PatchMapping("/{idFuncionario}/projeto/{idProjeto}")
    public ResponseEntity<FuncionarioProjetoResponseDto> associarFuncionarioProjeto(
            @PathVariable Long idFuncionario, @PathVariable Long idProjeto
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.associarFuncionarioProjeto(idFuncionario, idProjeto));
    }


}

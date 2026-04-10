package com.atividade.api.controller;

import com.atividade.api.dto.funcionario.FuncionarioRequestDto;
import com.atividade.api.dto.funcionario.FuncionarioResponseDto;
import com.atividade.api.dto.projeto.ProjetoRequestDto;
import com.atividade.api.dto.projeto.ProjetoResponseDto;
import com.atividade.api.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projeto")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ResponseEntity<ProjetoResponseDto> criar(@RequestBody ProjetoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }
    @GetMapping
    public ResponseEntity<List<ProjetoResponseDto>> listarTodos(){
        List<ProjetoResponseDto> projeto = service.listarTodos();
        return ResponseEntity.ok(projeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponseDto> atualizar(@RequestBody ProjetoRequestDto requestDto, @PathVariable Long id){
        ProjetoResponseDto projeto = service.atualizar(requestDto, id);
        return ResponseEntity.ok(projeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

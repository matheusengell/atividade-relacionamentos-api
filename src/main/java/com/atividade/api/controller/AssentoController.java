package com.atividade.api.controller;

import com.atividade.api.dto.assento.AssentoRequestDto;
import com.atividade.api.dto.assento.AssentoResponseDto;
import com.atividade.api.model.Assento;
import com.atividade.api.service.AssentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/assento")
public class AssentoController {

    private final AssentoService service;

    @PostMapping
    public ResponseEntity<AssentoResponseDto> criar( @RequestBody AssentoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarAssento(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<AssentoResponseDto>> listarTodos(){
        List<AssentoResponseDto> assento = service.listarTodos();
        return ResponseEntity.ok(assento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssentoResponseDto> atualizar(@RequestBody AssentoRequestDto requestDto, @PathVariable Long id){
        AssentoResponseDto responseDto = service.atualizar(requestDto, id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

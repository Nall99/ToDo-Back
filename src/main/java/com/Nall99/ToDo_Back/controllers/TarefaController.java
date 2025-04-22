package com.Nall99.ToDo_Back.controllers;

import com.Nall99.ToDo_Back.dtos.TarefaDTO;
import com.Nall99.ToDo_Back.models.Tarefa;
import com.Nall99.ToDo_Back.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody TarefaDTO tarefaDTO){
        try{
            String mensagem = this.tarefaService.salvar(tarefaDTO);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody TarefaDTO tarefaDTO, @PathVariable Long id){
        try {
            String mensagem = this.tarefaService.atualizar(tarefaDTO, id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        try{
            String mensagem = this.tarefaService.deletar(id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<TarefaDTO>> buscarTodos(){
        try{
            List<TarefaDTO> tarefaDTOS = this.tarefaService.buscarTodos();
            return new ResponseEntity<List<TarefaDTO>>(tarefaDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id){
        try{
            TarefaDTO tarefaDTO = this.tarefaService.buscarPorId(id);
            return new ResponseEntity<TarefaDTO>(tarefaDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

package com.Nall99.ToDo_Back.services;

import com.Nall99.ToDo_Back.dtos.TarefaDTO;
import com.Nall99.ToDo_Back.models.Tarefa;
import com.Nall99.ToDo_Back.repositories.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    ModelMapper modelMapper;

    // Converte TarefaDTO para Tarefa
    public Tarefa converterParaEntity(TarefaDTO tarefaDTO){
        return modelMapper.map(tarefaDTO, Tarefa.class);
    }

    // Converte Tarefa para TarefaDTO
    public TarefaDTO converterParaDTO(Tarefa tarefa){
        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    public String salvar(TarefaDTO tarefa){
        Tarefa tarefaModel = converterParaEntity(tarefa);
        tarefaRepository.save(tarefaModel);
        return "Tarefa salva com sucesso!";
    }

    public String atualizar(TarefaDTO tarefaAtualizada, Long id){
        Optional<Tarefa> tarefa = this.tarefaRepository.findById(id);
        if(tarefa.isPresent()){
            Tarefa tarefaAtualizadaModel = converterParaEntity(tarefaAtualizada);
            tarefaAtualizadaModel.setId(id);
            this.tarefaRepository.save(tarefaAtualizadaModel);
            return "Tarefa atualizada com sucesso";
        }else{
            return "Problema na atualização da tarefa";
        }
    }

    public String deletar(Long id){
        Optional<Tarefa> tarefa = this.tarefaRepository.findById(id);
        if(tarefa.isPresent()){
            this.tarefaRepository.delete(tarefa.get());
            return "Tarefa deletada com sucesso";
        }else{
            return "Problema em deletar a tarefa";
        }
    }

    public List<TarefaDTO> buscarTodos(){
        return this.tarefaRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public TarefaDTO buscarPorId(Long id){
        Optional<Tarefa> tarefa = this.tarefaRepository.findById(id);
        if(tarefa.isPresent()){
            return modelMapper.map(tarefa.get(), TarefaDTO.class);
        }else {
            return null;
        }
    }
}

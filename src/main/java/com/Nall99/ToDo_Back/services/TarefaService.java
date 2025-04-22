package com.Nall99.ToDo_Back.services;

import com.Nall99.ToDo_Back.dtos.TarefaDTO;
import com.Nall99.ToDo_Back.models.Tarefa;
import com.Nall99.ToDo_Back.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;

    // Converte TarefaDTO para Tarefa
    public Tarefa converterParaEntity(TarefaDTO tarefaDTO){
        Tarefa tarefaModel = new Tarefa();
        tarefaModel.setId(tarefaDTO.id());
        tarefaModel.setTitulo(tarefaDTO.titulo());
        tarefaModel.setDescricao(tarefaDTO.descricao());
        tarefaModel.setStatus(tarefaDTO.status());
        return tarefaModel;
    }

    // Converte Tarefa para TarefaDTO
    private TarefaDTO converterParaDTO(Tarefa tarefa) {
        return new TarefaDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.isFinalizado(),
                tarefa.getCriadoEm(),
                tarefa.getAtualiazadoEm()
        );
    }

    public String salvar(TarefaDTO tarefa){
        Tarefa tarefaModel = converterParaEntity(tarefa);
        tarefaModel.setCriadoEm(LocalDateTime.now());
        tarefaRepository.save(tarefaModel);
        return "Tarefa salva com sucesso!";
    }

    public String atualizar(TarefaDTO tarefaAtualizada, Long id){
        Optional<Tarefa> tarefa = this.tarefaRepository.findById(id);
        if(tarefa.isPresent()){
            Tarefa tarefaAtualizadaModel = converterParaEntity(tarefaAtualizada);
            tarefaAtualizadaModel.setId(id);
            tarefaAtualizadaModel.setAtualiazadoEm(LocalDateTime.now());
            tarefaAtualizadaModel.setCriadoEm(tarefa.get().getCriadoEm());
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
        return tarefa.map(this::converterParaDTO).orElse(null);
    }
}

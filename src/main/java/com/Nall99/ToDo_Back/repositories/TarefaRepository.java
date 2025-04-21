package com.Nall99.ToDo_Back.repositories;

import com.Nall99.ToDo_Back.dtos.TarefaDTO;
import com.Nall99.ToDo_Back.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> { }

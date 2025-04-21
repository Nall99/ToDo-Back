package com.Nall99.ToDo_Back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String texto;
    String status;
    Boolean finalizado;

}

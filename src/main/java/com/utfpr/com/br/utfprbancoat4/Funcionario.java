package com.utfpr.com.br.utfprbancoat4;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    private Long id;
    @Column
    private String nome;

    @ManyToOne
    @JoinColumn("id_departamento")
    private Departamento departamento;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

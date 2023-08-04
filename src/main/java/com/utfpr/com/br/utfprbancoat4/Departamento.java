package com.utfpr.com.br.utfprbancoat4;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    private Long id;
    @Column
    private String nome;


    @OneToMany(mappedBy = "funcionario",cascade = CascadeType.ALL)
    private ArrayList<Funcionario> funcionarios;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

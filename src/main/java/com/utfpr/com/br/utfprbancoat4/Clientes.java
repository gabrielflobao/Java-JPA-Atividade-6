package com.utfpr.com.br.utfprbancoat4;

import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;

@Entity
public class Clientes {
    @Id
    private Long id;
    @Column
    private String nome;


    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private ArrayList<Pedido> pedidoList;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

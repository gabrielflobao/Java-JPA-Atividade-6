package com.utfpr.com.br.utfprbancoat4;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    private Long id;
    @Column
    private String descricao;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

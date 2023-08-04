package com.utfpr.com.br.utfprbancoat4;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "autor")
public class Autores {

        @Id
        private Long id;
        @Column
        private String nome;

        @ManyToMany()
        @JoinTable(
                name = "tabela intermediaria",
                joinColumns = @JoinColumn(name = "autor_id"),
                inverseJoinColumns = @JoinColumn(name = "livro_id")
        )
        private ArrayList<Livros> Livros;


        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
}

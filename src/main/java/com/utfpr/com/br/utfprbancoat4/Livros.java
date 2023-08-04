package com.utfpr.com.br.utfprbancoat4;

import jakarta.persistence.*;

import java.util.ArrayList;

public class Livros {
        @Id
        private Long id;
        @Column
        private String nome;


        @OneToMany(mappedBy = "autores",cascade = CascadeType.ALL)
        private ArrayList<Autores> autores;


        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
}

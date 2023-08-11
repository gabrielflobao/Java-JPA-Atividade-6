package com.utfpr.com.br.utfprbancoat4.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
@NamedQuery(name = "Funcionario.findFuncionarioByDependentesNamedQuery", query = "SELECT f FROM Funcionario f WHERE f.qtdDependentes = :P_QTD_DEPENDENTES")
@NamedNativeQuery(name = "Funcionario.findFuncionarioByNameLike", query = "SELECT * FROM funcionario WHERE funcionario.nome like '%'||:P_NAME||'%'",resultClass = Funcionario.class)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidade_dependentes")
    private Integer qtdDependentes;
    @Column(name = "salario")
    private BigDecimal salario;
    @Column(name = "cargo")
    private String cargo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departamento_id", referencedColumnName = "id")
    private Departamento departamento;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdDependentes() {
        return qtdDependentes;
    }

    public void setQtdDependentes(Integer qtdDependentes) {
        this.qtdDependentes = qtdDependentes;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

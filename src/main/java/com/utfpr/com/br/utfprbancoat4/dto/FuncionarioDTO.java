package com.utfpr.com.br.utfprbancoat4.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FuncionarioDTO {

    private Long id;

    private String nome;

    private Integer qtdDependentes;

    private BigDecimal salario;

    private String cargo;
}

package com.utfpr.com.br.utfprbancoat4.dto;

import com.utfpr.com.br.utfprbancoat4.model.Departamento;
import com.utfpr.com.br.utfprbancoat4.model.Funcionario;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class DepartamentoDTO {

    private Long id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;





}

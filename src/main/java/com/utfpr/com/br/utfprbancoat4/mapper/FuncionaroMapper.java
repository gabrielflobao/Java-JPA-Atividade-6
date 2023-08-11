package com.utfpr.com.br.utfprbancoat4.mapper;

import com.utfpr.com.br.utfprbancoat4.dto.FuncionarioDTO;
import com.utfpr.com.br.utfprbancoat4.model.Funcionario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FuncionaroMapper {

    public static FuncionarioDTO toReponse(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setSalario(funcionario.getSalario());
        dto.setNome(funcionario.getNome());
        dto.setId(funcionario.getId());
        dto.setCargo(funcionario.getCargo());
        dto.setQtdDependentes(funcionario.getQtdDependentes());
        return dto;
    }
    public static List<FuncionarioDTO> toReponseList(List<Funcionario> array) {
        return array.stream().map(funcionario -> toReponse(funcionario)).collect(Collectors.toList());
    }
}

package com.utfpr.com.br.utfprbancoat4.mapper;

import com.utfpr.com.br.utfprbancoat4.dto.DepartamentoDTO;
import com.utfpr.com.br.utfprbancoat4.model.Departamento;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartamentoMapper {
    public static DepartamentoDTO toReponse(Departamento object) {
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setId(object.getId());
        dto.setNome(object.getDescricao());
        dto.setFuncionarios(FuncionaroMapper.toReponseList(object.getFuncionarioList()));
        return dto;
    }

    public static List<DepartamentoDTO> toReponseList(List<Departamento> list) {
        return list.stream().map(departamento -> toReponse(departamento)).collect(Collectors.toList());
    }
    public static List<DepartamentoDTO> toReponseList(Page<Departamento> list) {
        return list.stream().map(departamento -> toReponse(departamento)).collect(Collectors.toList());
    }
}

package com.utfpr.com.br.utfprbancoat4.service;

import com.utfpr.com.br.utfprbancoat4.dto.DepartamentoDTO;
import com.utfpr.com.br.utfprbancoat4.mapper.DepartamentoMapper;
import com.utfpr.com.br.utfprbancoat4.model.Departamento;
import com.utfpr.com.br.utfprbancoat4.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository repository;

    public  List<DepartamentoDTO> listaDepartamento(){
        return DepartamentoMapper.toReponseList(repository.findAll());
    }
    public Page<DepartamentoDTO> listarDepartamentoPaginado(Pageable pageable){
        Page<Departamento> page =  repository.findAll(pageable);
         return new PageImpl<>(DepartamentoMapper.toReponseList(page), PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), DepartamentoMapper.toReponseList(page).size());
    }

    public DepartamentoDTO findFirstDepartamento(){
        return DepartamentoMapper.toReponse(repository.findFirstDepartamento());
    }



}

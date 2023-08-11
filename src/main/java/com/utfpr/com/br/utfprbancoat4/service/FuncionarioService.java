package com.utfpr.com.br.utfprbancoat4.service;

import com.utfpr.com.br.utfprbancoat4.dto.FuncionarioDTO;
import com.utfpr.com.br.utfprbancoat4.mapper.FuncionaroMapper;
import com.utfpr.com.br.utfprbancoat4.model.Funcionario;
import com.utfpr.com.br.utfprbancoat4.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository repository;


    public List<FuncionarioDTO> findFuncionarioAndQtdDependentes (String nome,Integer qtdDependentes) {
        List<Funcionario> list = repository.findFuncionarioAndQtdDependentes(nome,qtdDependentes);
        return FuncionaroMapper.toReponseList(list);
    }
    public List<FuncionarioDTO> findFuncionarioByDepartamento (String nome) {
        List<Funcionario> list = repository.findFuncionarioByDepartamento(nome);
        return FuncionaroMapper.toReponseList(list);
    }

    public List<FuncionarioDTO> findTop3Salario () {
        List<Funcionario> list = repository.findTop3Salario();
        return FuncionaroMapper.toReponseList(list);
    }
    public List<FuncionarioDTO> findFuncionarioHasNotDependente () {
        List<Funcionario> list = repository.findFuncionarioHasNotDependente();
        return FuncionaroMapper.toReponseList(list);
    }

    public List<FuncionarioDTO> findFuncionarioBySalario (Double salario) {
        List<Funcionario> list = repository.findFuncionarioBySalario(salario);
        return FuncionaroMapper.toReponseList(list);
    }

    public List<FuncionarioDTO> findFuncionarioBySalarioNativeQ (Double salario) {
        List<Funcionario> list = repository.findFuncionarioBySalarioNativeQ(salario);
        return FuncionaroMapper.toReponseList(list);
    }

    public List<FuncionarioDTO> findFuncionarioByDependentesNamedQuery (Integer qtdDependente) {
        List<Funcionario> list = repository.findFuncionarioByDependentesNamedQuery(qtdDependente);
        return FuncionaroMapper.toReponseList(list);
    }

    public List<FuncionarioDTO> findFuncionarioByNameLike (String nome) {
        List<Funcionario> list = repository.findFuncionarioByNameLike(nome);
        return FuncionaroMapper.toReponseList(list);
    }
}



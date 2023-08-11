package com.utfpr.com.br.utfprbancoat4.controller;

import com.utfpr.com.br.utfprbancoat4.dto.DepartamentoDTO;
import com.utfpr.com.br.utfprbancoat4.dto.FuncionarioDTO;
import com.utfpr.com.br.utfprbancoat4.service.DepartamentoService;
import com.utfpr.com.br.utfprbancoat4.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private  FuncionarioService service;

    @GetMapping("/por-departamento-e-nome/")
    public ResponseEntity<List<FuncionarioDTO>> findFuncionarioDependente(@RequestParam String nome,@RequestParam Integer qtdDependente) {

        return new ResponseEntity<List<FuncionarioDTO>>(service.findFuncionarioAndQtdDependentes(nome,qtdDependente), HttpStatus.OK);

    }

    @GetMapping("/por-departamento/")
    public ResponseEntity<List<FuncionarioDTO>> findFuncionarioByDepartamento(@RequestParam String nome) {
        return new ResponseEntity<List<FuncionarioDTO>>(service.findFuncionarioByDepartamento(nome), HttpStatus.OK);
    }

    @GetMapping("/top-3-salarios")
    public ResponseEntity<List<FuncionarioDTO>> findTop3Salario() {
        return new ResponseEntity<List<FuncionarioDTO>>(service.findTop3Salario(), HttpStatus.OK);
    }

    @GetMapping("/funcionarios-sem-dependente")
    public ResponseEntity<List<FuncionarioDTO>> findFuncionarioHasNotDependente() {
        return ResponseEntity.ok(service.findFuncionarioHasNotDependente()) ;
    }

    @GetMapping("/por-dependente/")
    public ResponseEntity<List<FuncionarioDTO>> findFuncionarioBySalarioNativeQ(@RequestParam Double salario) {
        return ResponseEntity.ok(service.findFuncionarioBySalario(salario)) ;
    }

    @GetMapping("/por-dependente-named-query/")
    public ResponseEntity<List<FuncionarioDTO>> findFuncionarioByDependentesNamedQuery(@RequestParam Integer qtdDependente) {
        return ResponseEntity.ok(service.findFuncionarioByDependentesNamedQuery(qtdDependente)) ;
    }

    @GetMapping("/nome-funcionario-like/")
    public ResponseEntity<List<FuncionarioDTO>> findFuncionarioByNameLike(@RequestParam String nome) {
        return ResponseEntity.ok(service.findFuncionarioByNameLike(nome)) ;
    }
}

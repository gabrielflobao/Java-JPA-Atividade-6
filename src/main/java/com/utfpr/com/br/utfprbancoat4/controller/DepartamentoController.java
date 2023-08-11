package com.utfpr.com.br.utfprbancoat4.controller;

import com.utfpr.com.br.utfprbancoat4.dto.DepartamentoDTO;
import com.utfpr.com.br.utfprbancoat4.model.Departamento;
import com.utfpr.com.br.utfprbancoat4.repository.DepartamentoRepository;

import com.utfpr.com.br.utfprbancoat4.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;



@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;
    /*
        @GetMapping("/listar")
        public @ResponseBody ResponseEntity<List<DepartamentoDTO>> listaDepartamento() {
            return  new ResponseEntity<>(departamentoService.listaDepartamento(), HttpStatus.OK);
        }

        @GetMapping("/listar")
        public @ResponseBody Pagl<List<DepartamentoDTO>> listaDepartamento(@Param()) {
            return  new ResponseEntity<>(departamentoService.listaDepartamento(), HttpStatus.OK);
        }

       */
  @GetMapping("/listar")
    public ResponseEntity<Page<DepartamentoDTO>> getUsers(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DepartamentoDTO> users = departamentoService.listarDepartamentoPaginado(pageable);

        return ResponseEntity.ok(users);
    }

    @GetMapping("/primeiro-departamento")
    public ResponseEntity<DepartamentoDTO> findFirstDepartamento() {
        return ResponseEntity.ok(departamentoService.findFirstDepartamento()) ;
    }

}

package com.utfpr.com.br.utfprbancoat4.repository;

import com.utfpr.com.br.utfprbancoat4.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    @Query( value = "SELECT * FROM funcionario f where f.nome like :P_NOME and f.quantidade_dependentes = :P_QTD_DEPENDENTES ",nativeQuery = true)
    List<Funcionario> findFuncionarioAndQtdDependentes(@Param("P_NOME") String nome, @Param("P_QTD_DEPENDENTES") Integer qtdDependentes);

    @Query( value = "SELECT f FROM Funcionario f,Departamento p where f.departamento.id = p.id and p.descricao like :P_NOME_DEPARTAMENTO")
    List<Funcionario> findFuncionarioByDepartamento(@Param("P_NOME_DEPARTAMENTO") String nome);

    @Query( value = "SELECT * FROM (SELECT * FROM funcionario f  order by f.salario desc) where rownum<4",nativeQuery = true)
    List<Funcionario> findTop3Salario();

    @Query("select f  FROM Funcionario f WHERE f.qtdDependentes = 0 order by f.nome asc")
    List<Funcionario> findFuncionarioHasNotDependente();

    @Query("select f  FROM Funcionario f WHERE f.salario > :P_SALARIO")
    List<Funcionario> findFuncionarioBySalario(@Param("P_SALARIO") Double salario);

    @Query(value = "select *  FROM funcionario f WHERE f.salario > :P_SALARIO",nativeQuery = true)
    List<Funcionario> findFuncionarioBySalarioNativeQ(@Param("P_SALARIO") Double salario);

    @Query(name="Funcionario.findFuncionarioByDependentesNamedQuery")
    List<Funcionario> findFuncionarioByDependentesNamedQuery(@Param("P_QTD_DEPENDENTES") Integer qtdDependente);

    @Query(name="Funcionario.findFuncionarioByNameLike")
    List<Funcionario> findFuncionarioByNameLike(@Param("P_NAME") String name);

}

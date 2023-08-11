package com.utfpr.com.br.utfprbancoat4.repository;

import com.utfpr.com.br.utfprbancoat4.model.Departamento;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {

    @Override
    List<Departamento> findAll();

    @Override
    Page<Departamento> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM departamento where departamento.id = (select min(d2.id) from departamento d2)",nativeQuery = true)
    Departamento findFirstDepartamento();

}

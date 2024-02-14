package com.rvmsoft.sisventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmsoft.sisventas.model.GrupoUnidadMedida;

@Repository
public interface GrupoUnidadMedidaRepository extends JpaRepository<GrupoUnidadMedida, Long>{

}

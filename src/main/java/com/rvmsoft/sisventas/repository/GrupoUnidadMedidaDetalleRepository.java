package com.rvmsoft.sisventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmsoft.sisventas.model.GrupoUnidadMedidaDetalle;

@Repository
public interface GrupoUnidadMedidaDetalleRepository extends JpaRepository<GrupoUnidadMedidaDetalle, Long>{

}

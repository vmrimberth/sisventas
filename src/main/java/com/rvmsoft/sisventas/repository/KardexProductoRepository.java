package com.rvmsoft.sisventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmsoft.sisventas.model.KardexProducto;

@Repository
public interface KardexProductoRepository extends JpaRepository<KardexProducto, Long>{

}

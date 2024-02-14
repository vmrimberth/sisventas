package com.rvmsoft.sisventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmsoft.sisventas.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}

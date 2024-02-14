package com.rvmsoft.sisventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmsoft.sisventas.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}

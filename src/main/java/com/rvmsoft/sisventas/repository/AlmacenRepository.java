package com.rvmsoft.sisventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmsoft.sisventas.model.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long>{

}

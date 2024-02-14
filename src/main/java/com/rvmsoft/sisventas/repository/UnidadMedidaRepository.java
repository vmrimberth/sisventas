package com.rvmsoft.sisventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rvmsoft.sisventas.model.UnidadMedida;

@Repository
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida, Long> {

	@Query(value = "select * from public.fn_search_unidad_medida(?1)", nativeQuery = true, countQuery = "select count(*) from public.fn_search_unidad_medida(?1)")
	public List<UnidadMedida> findByKerwordSQL(String keyword);
	
}

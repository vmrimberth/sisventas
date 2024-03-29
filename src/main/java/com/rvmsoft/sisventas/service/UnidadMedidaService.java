package com.rvmsoft.sisventas.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rvmsoft.sisventas.dto.UnidadMedidaDTO;
import com.rvmsoft.sisventas.dto.request.UnidadMedidaDTORequest;
import com.rvmsoft.sisventas.model.UnidadMedida;

public interface UnidadMedidaService {

	public Long save(UnidadMedidaDTORequest dto);
	
	public UnidadMedida saveSQL(UnidadMedidaDTORequest dto);
	
	public UnidadMedida update(UnidadMedida unidadMedida, Long id);
	
	public UnidadMedidaDTO findById(Long id);
	
	public List<UnidadMedidaDTO> findAll();
	
	public List<UnidadMedidaDTO> findByKerword(String kerword);
	
	public Page<UnidadMedidaDTO> findByNombre(String nombre, Pageable pageable);
}

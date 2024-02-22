package com.rvmsoft.sisventas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rvmsoft.sisventas.dto.UnidadMedidaDTO;
import com.rvmsoft.sisventas.dto.request.UnidadMedidaDTORequest;
import com.rvmsoft.sisventas.errorhandler.EntityNotFoundException;
import com.rvmsoft.sisventas.mapper.UnidadMedidaMapper;
import com.rvmsoft.sisventas.model.UnidadMedida;
import com.rvmsoft.sisventas.repository.UnidadMedidaRepository;
import com.rvmsoft.sisventas.service.UnidadMedidaService;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService{

	private final UnidadMedidaRepository unidadMedidaRepository;
	private final UnidadMedidaMapper unidadMedidaMapper;
	
	
	public UnidadMedidaServiceImpl(UnidadMedidaRepository unidadMedidaRepository, UnidadMedidaMapper unidadMedidaMapper) {
		this.unidadMedidaRepository = unidadMedidaRepository;
		this.unidadMedidaMapper = unidadMedidaMapper;
	}

	@Override
	public Long save(UnidadMedidaDTORequest dto) {
		UnidadMedida unidadMedida = new UnidadMedida();
		unidadMedida.setNombre(dto.getNombre());
		unidadMedida.setAbreviacion(dto.getAbreviacion());
		return this.unidadMedidaRepository.save(unidadMedida).getId();
	}

	@Override
	public UnidadMedida saveSQL(UnidadMedidaDTORequest dto) {
		UnidadMedida unidadMedida = new UnidadMedida();
		unidadMedida.setNombre(dto.getNombre());
		unidadMedida.setAbreviacion(dto.getAbreviacion());
		return this.unidadMedidaRepository.save(unidadMedida);
	}
	
	@Override
	public UnidadMedida update(UnidadMedida unidadMedida, Long id) {
		UnidadMedida bean = this.unidadMedidaRepository.findById(id).get();
		bean.setNombre(unidadMedida.getNombre());
		bean.setAbreviacion(unidadMedida.getAbreviacion());
		return this.unidadMedidaRepository.save(bean);
	}

	@Override
	public UnidadMedidaDTO findById(Long id) {
		UnidadMedida unidadMedida = this.unidadMedidaRepository.findById(id)
				.orElseThrow(()->new EntityNotFoundException(String.format("La unidad de medida con id %s no exite", id.toString())));
		return UnidadMedidaDTO.builder().id(unidadMedida.getId()).nombre(unidadMedida.getNombre()).build();
	}

	@Override
	public List<UnidadMedidaDTO> findAll() {
		List<UnidadMedida> unidadMedidaList = this.unidadMedidaRepository.findAll();
		List<UnidadMedidaDTO> unidadMedidaListDTO = new ArrayList<>() ;
		unidadMedidaList.forEach((bean)->{
			unidadMedidaListDTO.add(UnidadMedidaDTO.builder().id(bean.getId()).nombre(bean.getNombre()).build());
		});
		return unidadMedidaListDTO;
	}

	@Override
	public List<UnidadMedidaDTO> findByKerword(String kerword) {
		List<UnidadMedida> list = this.unidadMedidaRepository.findByKerwordSQL(kerword);
		return list.stream().map((bean)->convertBeanToDto(bean)).collect(Collectors.toList());
	}
	
	public UnidadMedidaDTO convertBeanToDto(UnidadMedida um) {
		return UnidadMedidaDTO.builder().id(um.getId()).nombre(um.getNombre()).build();
	}

	/*@Override
	public Page<UnidadMedidaDTO> findByNombre(String nombre, Pageable pageable) {
		Page<UnidadMedida> list = this.unidadMedidaRepository.findByNombre(nombre, pageable);
		return list.map((bean)->convertBeanToDto(bean));
	}*/
	
	@Override
	public Page<UnidadMedidaDTO> findByNombre(String nombre, Pageable pageable) {
		Page<UnidadMedida> list = this.unidadMedidaRepository.findByNombre(nombre, pageable);
		return list.map((bean)->unidadMedidaMapper.toDto(bean));
	}
	
}

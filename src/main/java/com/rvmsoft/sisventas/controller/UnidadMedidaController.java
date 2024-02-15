package com.rvmsoft.sisventas.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rvmsoft.sisventas.dto.PageableDTO;
import com.rvmsoft.sisventas.dto.UnidadMedidaDTO;
import com.rvmsoft.sisventas.dto.request.UnidadMedidaDTORequest;
import com.rvmsoft.sisventas.service.UnidadMedidaService;
import com.rvmsoft.sisventas.util.SisVentasUtil;

import lombok.extern.slf4j.Slf4j;

import com.rvmsoft.sisventas.constant.SisVentasConstant;


@Slf4j
@RestController
@RequestMapping(SisVentasConstant.RESOURCE_GENERIC)
@CrossOrigin(SisVentasConstant.CLIENT_FRONTEND)
public class UnidadMedidaController {

	private final UnidadMedidaService unidadMedidaService;
	
	private final SisVentasUtil util;

	public UnidadMedidaController(UnidadMedidaService unidadMedidaService, SisVentasUtil util) {
		this.unidadMedidaService = unidadMedidaService;
		this.util = util;
	}
	
	@PostMapping(SisVentasConstant.RESOURCE_UNIDAD_MEDIDAS + SisVentasConstant.RESOURCE_UNIDAD_MEDIDA)
	public Long save(@RequestBody UnidadMedidaDTORequest dto) {
		return this.unidadMedidaService.save(dto);
	}
	
	@GetMapping(SisVentasConstant.RESOURCE_UNIDAD_MEDIDAS + SisVentasConstant.RESOURCE_UNIDAD_MEDIDA)
	public List<UnidadMedidaDTO> findAll(){
		return this.unidadMedidaService.findAll();
	}
	
	@GetMapping(SisVentasConstant.RESOURCE_UNIDAD_MEDIDAS + SisVentasConstant.RESOURCE_UNIDAD_MEDIDA + SisVentasConstant.RESOURCE_GENERIC_ID)
	public UnidadMedidaDTO findById(@PathVariable Long id) {
		return this.unidadMedidaService.findById(id);
	}
	
	@GetMapping(SisVentasConstant.RESOURCE_UNIDAD_MEDIDAS + SisVentasConstant.RESOURCE_UNIDAD_MEDIDA_KEY)
	public List<UnidadMedidaDTO> findByKerword(@RequestParam String keyword) {
		return this.unidadMedidaService.findByKerword(keyword);
	}
	
	/*@GetMapping(SisVentasConstant.RESOURCE_UNIDAD_MEDIDAS + SisVentasConstant.RESOURCE_UNIDAD_MEDIDA+"/nombre")
	public Page<UnidadMedidaDTO> findByNombre(@RequestParam String nombre, Pageable pageable){
		return this.unidadMedidaService.findByNombre(nombre, pageable);
	}*/
	
	@GetMapping(SisVentasConstant.RESOURCE_UNIDAD_MEDIDAS + SisVentasConstant.RESOURCE_UNIDAD_MEDIDA+"/nombre")
	public Page<UnidadMedidaDTO> findByNombre(@RequestParam String nombre, PageableDTO pageable){
		log.info("crear UnidadMedidaController -> {} " + pageable);
		return this.unidadMedidaService.findByNombre(nombre, util.getPageable(pageable));
	}
}

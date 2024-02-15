package com.rvmsoft.sisventas.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UnidadMedidaDTO implements Serializable{

	private Long id;
	private String nombre;
	
	public UnidadMedidaDTO(Long id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}
}

package com.rvmsoft.sisventas.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UnidadMedidaDTO implements Serializable{

	private Long id;
	private String nombre;
	

}

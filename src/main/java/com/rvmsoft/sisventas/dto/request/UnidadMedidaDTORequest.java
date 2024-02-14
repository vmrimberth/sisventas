package com.rvmsoft.sisventas.dto.request;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UnidadMedidaDTORequest implements Serializable{

	private String nombre;
	private String abreviacion;
	
}

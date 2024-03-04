package com.rvmsoft.sisventas.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UnidadMedidaDTORequest implements Serializable{

	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min=10, max=60)
	private String nombre;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min=10, max=60)
	private String abreviacion;
	
}

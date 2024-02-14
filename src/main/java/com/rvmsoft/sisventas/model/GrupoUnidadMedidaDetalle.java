package com.rvmsoft.sisventas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="tbl_grupo_unidad_medida_detalle", schema="public")
public class GrupoUnidadMedidaDetalle {

	@Id
	@Column(name="id_grupo_unidad_medida_detalle")
	private Long id;
	
	@Column(name="id_grupo_unidad_medida")
	private Integer idGrupoUnidadMedida;
	
	@Column(name = "id_unidad_medida")
	private Integer idUnidadMedida;
}

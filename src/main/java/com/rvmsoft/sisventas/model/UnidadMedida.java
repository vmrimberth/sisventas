package com.rvmsoft.sisventas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="tbl_unidad_medida", schema="public")
public class UnidadMedida {
	
	@Id
	@Column(name="id_unidad_medida")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="abreviacion", length = 50)
	private String abreviacion;
	
	@Column(name = "nombre", length = 300)
	private String nombre;
	
}

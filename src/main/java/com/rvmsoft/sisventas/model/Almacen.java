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
@Table(name="tbl_almacen", schema="public")
public class Almacen {
	
	@Id
	@Column(name="id_almacen")
	private Long id;
	
	@Column(name="codigo", length = 50)
	private String codigo;
	
	@Column(name = "nombre", length = 300)
	private String nombre;
	
	@Column(name = "ubicacion", length = 300)
	private String ubicacion;
}

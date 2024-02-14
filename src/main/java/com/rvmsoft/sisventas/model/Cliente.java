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
@Table(name="tbl_cliente", schema="public")
public class Cliente {

	@Id
	@Column(name="id_cliente")
	private Long id;
	
	@Column(name="codigo", length = 50)
	private String codigo;
	
	@Column(name = "nombre", length = 300)
	private String nombre;
	
	@Column(name = "nit", length = 50)
	private String nit;
	
	@Column(name = "ci", length = 50)
	private String ci;
}

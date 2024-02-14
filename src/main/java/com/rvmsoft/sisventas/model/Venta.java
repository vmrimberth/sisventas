package com.rvmsoft.sisventas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="tbl_venta", schema="public")
public class Venta {

	@Id
	@Column(name="id_venta")
	private Long id;
	
	@Column(name="codigo", length = 50)
	private String codigo;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name="id_cliente")
	private Integer idCliente;
}

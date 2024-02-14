package com.rvmsoft.sisventas.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="tbl_venta_detalle", schema="public")
public class VentaDetalle {

	@Id
	@Column(name="id_venta_detalle")
	private Long id;
	
	@Column(name="id_venta")
	private Integer idVenta;
	
	@Column(name="id_kardex_producto")
	private Integer idKardexProducto;
	
	@Column(name="cantidad")
	private BigDecimal cantidad;
	
}

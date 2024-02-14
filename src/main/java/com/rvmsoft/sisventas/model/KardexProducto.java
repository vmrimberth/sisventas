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
@Table(name="tbl_kardex_producto", schema="public")
public class KardexProducto {

	@Id
	@Column(name="id_kardex_producto")
	private Long id;
	
	@Column(name="id_producto")
	private Integer idProducto;
	
	@Column(name="id_unidad_medida")
	private Integer idUnidadMedida;
	
	@Column(name="id_almacen")
	private Integer idAlmacen;
	
	@Column(name="precio")
	private BigDecimal precio;
}

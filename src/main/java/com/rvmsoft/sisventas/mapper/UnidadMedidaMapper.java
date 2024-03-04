package com.rvmsoft.sisventas.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import com.rvmsoft.sisventas.dto.UnidadMedidaDTO;
import com.rvmsoft.sisventas.dto.request.UnidadMedidaDTORequest;
import com.rvmsoft.sisventas.model.UnidadMedida;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UnidadMedidaMapper {

	public UnidadMedida toBean(UnidadMedidaDTORequest dto);
	
	public UnidadMedidaDTO toDto(UnidadMedida unidadMedida);
}

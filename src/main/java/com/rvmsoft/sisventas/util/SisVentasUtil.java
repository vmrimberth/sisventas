package com.rvmsoft.sisventas.util;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.rvmsoft.sisventas.dto.PageableDTO;

@Component
public final class SisVentasUtil {

	public Pageable getPageable(PageableDTO dto) {
		Optional<Integer> sortOrder = dto.getOrder();
		Optional<String> sortField = dto.getField();
		Integer pageNumber = dto.getPageNumber();
		Integer perPage = dto.getPageSize();
		
		Pageable pageable;
		if(sortOrder.isPresent() && sortField.isPresent()) {
			Sort.Direction direction = sortOrder.get().equals(1) ? Sort.Direction.ASC : Sort.Direction.DESC;
			pageable = PageRequest.of(pageNumber, perPage, Sort.by(direction, sortField.get()));
		}else {
			pageable = PageRequest.of(pageNumber, perPage, Sort.by(Sort.Direction.DESC, sortField.get()));
		}
		return pageable;
	}
}

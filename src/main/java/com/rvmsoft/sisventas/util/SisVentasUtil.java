package com.rvmsoft.sisventas.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	public Map<Integer, String> countries(){
		
		Map<Integer, String> countries = new HashMap<>();
		countries.put(1, "Peru");
		countries.put(2, "Chile");
		countries.put(3, "Argentina");
		countries.put(4, "Paraguay");
		countries.put(5, "Uruguay");
		countries.put(6, "Brazil");
		countries.put(7, "Ecuador");
		countries.put(8, "Colombia");
		countries.put(9, "Venezuela");
		countries.put(10, "Colombia");
		
		final Map<Integer, String> sortedMap = countries.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(c, v) -> c, LinkedHashMap::new));
		
		sortedMap.forEach((clave, valor)->{
			System.out.println(String.format("Nro: %02d Pais: %s", clave, valor));
		});
		
		return sortedMap;
	}
}

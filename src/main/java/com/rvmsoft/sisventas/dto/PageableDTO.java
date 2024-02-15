package com.rvmsoft.sisventas.dto;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageableDTO implements Pageable{

	private Integer page;
	private Integer size;
	private Optional<Integer> order;
	private Optional<String> field;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Optional<Integer> getOrder() {
		return order;
	}
	public void setOrder(Optional<Integer> order) {
		this.order = order;
	}
	public Optional<String> getField() {
		return field;
	}
	public void setField(Optional<String> field) {
		this.field = field;
	}

	@Override
	public int getPageNumber() {
		return page;
	}
	
	@Override
	public int getPageSize() {
		return size;
	}
	
	@Override
	public long getOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousOrFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable withPage(int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
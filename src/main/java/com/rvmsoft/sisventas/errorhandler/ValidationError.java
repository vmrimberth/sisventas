package com.rvmsoft.sisventas.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError extends SubError{

	private String object;
	private String filed;
	private Object rejectValue;
	private String message;
	
	public ValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}
}

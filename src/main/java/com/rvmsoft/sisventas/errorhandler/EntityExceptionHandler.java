package com.rvmsoft.sisventas.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rvmsoft.sisventas.constant.SisVentasConstant;

@RestControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(HttpStatusCodeException.class)
	protected ResponseEntity<Object> handleHttpRestClient(HttpStatusCodeException ex) {
		ErrorDTO sysceError = null;
		if (ex.getStatusCode().is4xxClientError()) {
			sysceError = new ErrorDTO(ex.getStatusCode(), SisVentasConstant.PREFIX_CLIENT_ERROR);
		} else if (ex.getStatusCode().is5xxServerError()) {
			sysceError = new ErrorDTO(ex.getStatusCode(), SisVentasConstant.PREFIX_SERVER_ERROR);
		}
		sysceError.setMessage(ex.getStatusText());
		return buildResponseEntity(sysceError);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		ErrorDTO sysceError = new ErrorDTO(HttpStatus.NOT_FOUND,
				SisVentasConstant.PREFIX_CLIENT_ERROR + SisVentasConstant.NOT_FOUND);
		sysceError.setMessage(ex.getMessage());
		return buildResponseEntity(sysceError);
	}
	 
	private ResponseEntity<Object> buildResponseEntity(ErrorDTO errorDTO) {
		return new ResponseEntity<>(errorDTO, errorDTO.getHttpStatus());
	}

}

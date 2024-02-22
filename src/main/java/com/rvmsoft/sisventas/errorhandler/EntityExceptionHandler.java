package com.rvmsoft.sisventas.errorhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rvmsoft.sisventas.constant.SisVentasConstant;

@RestControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(HttpStatusCodeException.class)
	protected ResponseEntity<Object> handleHttpRestClient(HttpStatusCodeException ex) {
		ErrorDTO errorDto = null;
		if (ex.getStatusCode().is4xxClientError()) {
			errorDto = new ErrorDTO(ex.getStatusCode(), SisVentasConstant.PREFIX_CLIENT_ERROR);
		} else if (ex.getStatusCode().is5xxServerError()) {
			errorDto = new ErrorDTO(ex.getStatusCode(), SisVentasConstant.PREFIX_SERVER_ERROR);
		}
		errorDto.setMessage(ex.getStatusText());
		return buildResponseEntity(errorDto);
	}

	@ExceptionHandler(EntityUnprocessableException.class)
	protected ResponseEntity<Object> handleConflict(EntityUnprocessableException ex) {
		ErrorDTO errorDto = new ErrorDTO(HttpStatus.UNPROCESSABLE_ENTITY,
				SisVentasConstant.PREFIX_CLIENT_ERROR + SisVentasConstant.UNPROCESSABLE_ENTITY);
		errorDto.setMessage(ex.getMessage());
		return buildResponseEntity(errorDto);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		ErrorDTO errorDto = new ErrorDTO(HttpStatus.NOT_FOUND,
				SisVentasConstant.PREFIX_CLIENT_ERROR + SisVentasConstant.NOT_FOUND);
		errorDto.setMessage(ex.getMessage());
		return buildResponseEntity(errorDto);
	}

	@ExceptionHandler(EntityGenericClientException.class)
	protected ResponseEntity<Object> handleGenericClientException(EntityGenericClientException ex) {
		ErrorDTO errorDto = new ErrorDTO(ex.getHttpStatus(), SisVentasConstant.PREFIX_CLIENT_ERROR);
		errorDto.setMessage(ex.getMessage());
		errorDto.setSubErrors(ex.getSubErrors());
		return buildResponseEntity(errorDto);
	}

	@ExceptionHandler(EntityUnauthorizedException.class)
	protected ResponseEntity<Object> handleEntityUnauthorized(EntityUnauthorizedException ex) {
		ErrorDTO errorDto = new ErrorDTO(HttpStatus.UNAUTHORIZED,
				SisVentasConstant.PREFIX_CLIENT_ERROR + SisVentasConstant.UNAUTHORIZED);
		errorDto.setMessage(ex.getMessage());
		return buildResponseEntity(errorDto);
	}

	@ExceptionHandler(EntityGenericServerException.class)
	protected ResponseEntity<Object> handleGenericServerException(EntityGenericServerException ex) {
		ErrorDTO errorDto = null;
		if (ex.getCode() != null) {
			errorDto = new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, ex.getCode());
		} else {
			errorDto = new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR,
					SisVentasConstant.PREFIX_SERVER_ERROR + SisVentasConstant.INTERNAL_SERVER_ERROR);
		}
		errorDto.setMessage(ex.getMessage());
		return buildResponseEntity(errorDto);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleError(Exception ex) {
		ErrorDTO errorDto = new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR,
				SisVentasConstant.PREFIX_SERVER_ERROR + SisVentasConstant.INTERNAL_SERVER_ERROR);
		errorDto.setMessage("Error generico de servidor " + ex.getMessage());
		return buildResponseEntity(errorDto);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ErrorDTO(HttpStatus.BAD_REQUEST,
				SisVentasConstant.PREFIX_CLIENT_ERROR + SisVentasConstant.BAD_REQUEST, error, ex));
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";

		return buildResponseEntity(new ErrorDTO(HttpStatus.BAD_REQUEST,
				SisVentasConstant.PREFIX_CLIENT_ERROR + SisVentasConstant.BAD_REQUEST, error, ex));
	}

	protected List<SubError> fillValidationErrorsFrom(MethodArgumentNotValidException argumentNotValid) {
		List<SubError> subErrorCollection = new ArrayList<>();
		argumentNotValid.getBindingResult().getFieldErrors().get(0).getRejectedValue();
		argumentNotValid.getBindingResult().getFieldErrors().stream().forEach((objError) -> {
			SubError sysceSubError = new ValidationError(objError.getObjectName(),
					objError.getField(), objError.getRejectedValue(), objError.getDefaultMessage());
			subErrorCollection.add(sysceSubError);
		});
		return subErrorCollection;
	}

	private ResponseEntity<Object> buildResponseEntity(ErrorDTO errorDTO) {
		return new ResponseEntity<>(errorDTO, errorDTO.getHttpStatus());
	}
	
}

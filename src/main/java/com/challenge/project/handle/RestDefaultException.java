package com.challenge.project.handle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.challenge.project.error.ErrorDetail;

@ControllerAdvice
public class RestDefaultException {

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<?> reponseMyException(Exception e) {
		e.printStackTrace();
		ErrorDetail error = ErrorDetail.builder().status(HttpStatus.BAD_REQUEST.value())
				.message(e.getLocalizedMessage()).title("Request Error").timestamp(new Date().getTime()).build();

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		ErrorDetail error = buildResponseError(methodArgumentNotValidException, HttpStatus.BAD_REQUEST,
				"Invalid Field");

		Map<String, String> fieldsError = new HashMap<>();

		methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(field -> {
			fieldsError.put(field.getField(), field.getDefaultMessage());
		});

		error.setFieldsError(fieldsError);

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> methodArgumentNotValidException(
			ConstraintViolationException constraintViolationException) {
		ErrorDetail error = buildResponseError(constraintViolationException, HttpStatus.BAD_REQUEST, "Invalid Field");

		for (ConstraintViolation<?> constraintViolation : constraintViolationException.getConstraintViolations()) {
			error.setMessage(constraintViolation.getMessage());
			break;
		}

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	private ErrorDetail buildResponseError(Exception ex, HttpStatus httpStatus, String messagem) {
		return ErrorDetail.builder().status(httpStatus.value()).message(ex.getMessage()).title(messagem)
				.timestamp(new Date().getTime()).build();
	}

}

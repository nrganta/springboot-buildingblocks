package com.stacksimplify.restservices.exceptions;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stacksimplify.restservices.exceptions.CustomErrorDetails;

@ControllerAdvice
public class CustomGlobalExcpetionHanlder extends ResponseEntityExceptionHandler {

	//MethodArgumentNotValid Exception
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(
				new Date(),"From Method Argument not valid exception GEHL",
				ex.getMessage());
		return new ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}
	@Override
	
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails=new CustomErrorDetails(
				new Date(),"From HttpRequestMethodNotSupported in not valid exception GEHL--Method not allowed",
				ex.getMessage());
		return new ResponseEntity<Object>(customErrorDetails,HttpStatus.METHOD_NOT_ALLOWED);
	}
	//Username Not found excepttion
	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,WebRequest request)
	{
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(
				new Date(),ex.getMessage(),
				request.getDescription(true));
		return new ResponseEntity<>(customErrorDetails,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,WebRequest request)
	{
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(
				new Date(),ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
}

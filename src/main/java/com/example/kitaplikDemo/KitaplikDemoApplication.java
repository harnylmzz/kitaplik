package com.example.kitaplikDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kitaplikDemo.core.exceptions.BusinessException;
import com.example.kitaplikDemo.core.exceptions.ProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class KitaplikDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitaplikDemoApplication.class, args);

	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	

}

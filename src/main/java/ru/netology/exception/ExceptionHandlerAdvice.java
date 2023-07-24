package ru.netology.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<String> icHandler(InvalidCredentials e) {
		return new ResponseEntity<>("Exception in getAuthorities method", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> nfHandler(AccountNotFoundException e) {
		return new ResponseEntity<>("Exception in getAuthorities method", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnauthorizedUser.class)
	public ResponseEntity<String> uuHandler(UnauthorizedUser e) {
		return new ResponseEntity<>("Exception in getAuthorities method", HttpStatus.UNAUTHORIZED);
	}
}

package ru.netology.exception;

public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException() {
	}

	public AccountNotFoundException(String msg) {
		super(msg);
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountNotFoundException(Throwable cause) {
		super(cause);
	}

	public AccountNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

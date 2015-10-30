package br.com.control;

public class ExceptionControl extends RuntimeException {

	public ExceptionControl() {
		super();
	}

	public ExceptionControl(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionControl(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionControl(String message) {
		super(message);
	}

	public ExceptionControl(Throwable cause) {
		super(cause);		
	}

}

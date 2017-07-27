package com.msd.ham.exception;

public class HAMException extends Exception {
	
	private static final long serialVersionUID = 6686688596944044144L;
	
	public HAMException(String msj, Throwable cause) {
		super(msj,cause);
	}
	
	public HAMException(String msj) {
		super(msj);
	}
	
	public HAMException(Throwable cause) {
		super(cause);
	}
}

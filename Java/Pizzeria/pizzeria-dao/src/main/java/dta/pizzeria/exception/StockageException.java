package dta.pizzeria.exception;

import java.io.IOException;

public class StockageException extends Exception {
	public StockageException() {
		// TODO Auto-generated constructor stub
	}

	public StockageException(String error, Exception e) {
		super(error, e);
	}

}

package dta.pizzeria.exception;

import java.io.IOException;

public class SavePizzaException extends StockageException {

	private static final long serialVersionUID = 1L;

	public SavePizzaException(String error, IOException e) {
		super(error, e);
	}
}

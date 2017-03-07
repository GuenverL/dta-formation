package dta.pizzeria.exception;

import java.io.IOException;

public class SavePizzaException extends StockageException {

	public SavePizzaException(String error, IOException e) {
		super(error, e);
	}
}

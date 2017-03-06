package dta.pizzeria.exception;

public class SavePizzaException extends StockageException {
	public SavePizzaException() {
	}

	public SavePizzaException(String error) {
		super(error);
	}
}

package dta.pizzeria.exception;

public class UpdatePizzaException extends StockageException {
	public UpdatePizzaException() {
	}

	public UpdatePizzaException(String error, Exception e) {
		super(error, e);
	}

}

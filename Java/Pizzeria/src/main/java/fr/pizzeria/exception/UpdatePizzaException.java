package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException {
	public UpdatePizzaException() {
	}

	public UpdatePizzaException(String error) {
		super(error);
	}

}

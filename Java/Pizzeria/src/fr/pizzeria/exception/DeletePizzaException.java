package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException {
	public DeletePizzaException() {
	}

	public DeletePizzaException(String error) {
		super(error);
	}

}

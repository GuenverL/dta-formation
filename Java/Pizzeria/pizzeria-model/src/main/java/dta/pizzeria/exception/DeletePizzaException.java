package dta.pizzeria.exception;

public class DeletePizzaException extends StockageException {

	private static final long serialVersionUID = 1L;

	public DeletePizzaException(String error, Exception e) {
		super(error, e);
	}

}

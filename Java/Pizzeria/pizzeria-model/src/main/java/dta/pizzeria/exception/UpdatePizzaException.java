package dta.pizzeria.exception;

public class UpdatePizzaException extends StockageException {

	private static final long serialVersionUID = 1L;

	public UpdatePizzaException(String error, Exception e) {
		super(error, e);
	}

}

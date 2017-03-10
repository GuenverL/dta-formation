package dta.pizzeria.exception;

public class StockageException extends RuntimeException {

	protected static final long serialVersionUID = 1L;

	public StockageException(String error, Exception e) {
		super(error, e);
	}

	public StockageException(String string) {
		super(string);
	}

}

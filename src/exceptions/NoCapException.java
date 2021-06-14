package exceptions;

public class NoCapException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoCapException() {
		super("Please write your nickname in lower case");
	}

}

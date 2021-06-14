package exceptions;

public class LongNicknameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LongNicknameException() {
		super("Nickname is too long. Please enter a shorter one");	}

}

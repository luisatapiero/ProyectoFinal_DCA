package exceptions;

public class GameOverException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameOverException() {
		super ("Has perdido, vuelve a intentarlo");
	}

}

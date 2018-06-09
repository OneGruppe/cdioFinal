package exceptions;

public class DALException extends Exception {
	private static final long serialVersionUID = -648120467892409553L;

	public DALException() 
	{
		super();
	}

	public DALException(String msg) 
	{
		super(msg);
	}


}

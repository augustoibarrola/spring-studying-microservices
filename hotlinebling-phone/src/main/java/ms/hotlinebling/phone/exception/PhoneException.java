package ms.hotlinebling.phone.exception;

public class PhoneException extends Exception 
{
	public PhoneException() {};
	
	public PhoneException(String message) 
	{
		super(message);
	}
	public PhoneException(Throwable cause)
	{
		super(cause);
	}
	public PhoneException(String message, Throwable cause)
	{
		super(message, cause);
	}

}

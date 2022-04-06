package ms.hotlinebling.customer.exception;

@SuppressWarnings("serial")
public class CustomerException extends Exception 
{
	public CustomerException() {};
	
	public CustomerException(String message)
	{
		super(message);
	}
	
	public CustomerException(Throwable cause)
	{
		super(cause);
	}
	
	public CustomerException(String message, Throwable cause)
	{
		super (message, cause);
	}
}

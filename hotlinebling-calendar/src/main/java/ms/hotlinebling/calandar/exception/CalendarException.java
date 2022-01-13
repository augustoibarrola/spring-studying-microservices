package ms.hotlinebling.calandar.exception;

public class CalendarException extends Exception 
{
	public CalendarException() {};
	
	public CalendarException(String message)
	{
		super(message);
	}
	
	public CalendarException(Throwable cause)
	{
		super(cause);
	}
	
	public CalendarException(String message, Throwable cause)
	{
		super (message, cause);
	}
}

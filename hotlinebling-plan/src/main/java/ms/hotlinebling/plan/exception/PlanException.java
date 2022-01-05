package ms.hotlinebling.plan.exception;

@SuppressWarnings("serial")
public class PlanException extends Exception {

public PlanException() {};
	
	public PlanException(String message) 
	{
		super(message);
	}
	public PlanException(Throwable cause)
	{
		super(cause);
	}
	public PlanException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
}

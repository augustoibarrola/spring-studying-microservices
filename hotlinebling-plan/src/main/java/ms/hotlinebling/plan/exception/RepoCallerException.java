package ms.hotlinebling.plan.exception;

public class RepoCallerException extends Exception 
{
	public RepoCallerException() {};
	
	public RepoCallerException(String message) 
	{
		super(message);
	}
	public RepoCallerException(Throwable cause)
	{
		super(cause);
	}
	public RepoCallerException(String message, Throwable cause)
	{
		super(message, cause);
	}

}

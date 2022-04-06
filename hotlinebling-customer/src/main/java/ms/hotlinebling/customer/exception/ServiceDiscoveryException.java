package ms.hotlinebling.customer.exception;

@SuppressWarnings("serial")
public class ServiceDiscoveryException extends Exception 
{
	public ServiceDiscoveryException() {};
	
	public ServiceDiscoveryException(String message)
	{
		super(message);
	}
	
	public ServiceDiscoveryException(Throwable cause)
	{
		super(cause);
	}
	
	public ServiceDiscoveryException(String message, Throwable cause)
	{
		super (message, cause);
	}

}

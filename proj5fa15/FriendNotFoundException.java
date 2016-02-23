package proj5fa15;

/**
 * Title: FriendNotFoundException.java
 * Description: Exception class used when a Person is not found.
 *
 * @author Saad Ahmad
 */

@SuppressWarnings("serial")
public class FriendNotFoundException extends RuntimeException
{
	/**
	 * Initializes a FriendNotFoundException storing an appropriate message
	 */
	public FriendNotFoundException(String msg)
	{
		super(msg);
	}
}

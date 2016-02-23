package proj5fa15;

/**
 * Title: FriendList.java
 * Description: Contains a linked list that represents 
 * 				a person's friend list. Contains methods to 
 * 				access or modify the friend list
 *
 * @author Saad Ahmad
 */

public class FriendList
{
	//instance variables
	private Node first;
	private int count;
	private Node loopPosition;

	/** default constructor - Initializes count to 0, loopPosition to null
	 * 						  and first to a Node that has no item and points to a null Node. 
	 * 						  Those two nodes will be used as header and trailer sentinels.
	 */
	public FriendList()
	{
		first = new Node(null, new Node(null));
		count = 0;
		loopPosition = null;
	}

	  /**
     * size - Returns the number of friends in the friend list.
     *
     * @return int count - the number of friends in the friend list
     */
	public int size()
	{
		return count;
	}

	/**
     * isEmpty - Checks if the friend list is empty.
     *
     * @return boolean true if the list does not contain at least one Person, false otherwise
     */
	public boolean isEmpty()
	{
		return count == 0;
	}

	/**
     * addToFront - Adds a Person to the front of the friend list.
     *
     * @param user the person to be added
     */
	public void addToFront(Person user)
	{
		first.setNext(new Node(user, first.getNext()));
		count++;
	}

	/**
     * remove - Removes a Person from the friend list.
     *
     * @param target the Person to be removed from the friend list
     * @return Person a reference to the Person that was removed
     */
	public Person remove(Person target)
	{
		Node current = first.getNext();
		Node prev = first;
		boolean removed = false;
		while ((current.getPerson() != null) && (!removed))
        {
            if (current.getPerson().equals(target))
            {
                prev.setNext(current.getNext());
                count--;
                removed = true;
            }
            prev = current;
            current = current.getNext();
        }
		return target;
	}

	/**
     * resetList - Sets loopPosition to the first data node i.e. node after header sentinel.
     */
	public void resetList()
	{
		loopPosition = first.getNext();
	}

	/**
     * getNextPerson - Returns the next Person in the list and shifts loopPosition one over.
     *
     * @return Person a reference to the next Person in the list
     */
	public Person getNextPerson()
	{
		Person temp = loopPosition.getPerson();
		loopPosition = loopPosition.getNext();
		return temp;
	}

	/**
     * search - Checks if the person is present in the friendlist
     *
     * @param target the Person to be searched for
     * @return boolean true if the Person is in the list, false otherwise
     */
	public boolean search(Person target)
	{
		Node current = first.getNext();
		while (current.getPerson() != null)
		{
			if (current.getPerson().equals(target))
			{
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	/**
     * listOfFriends - Displays all the names in the friend list.
     *
     * @return String a string containing names of all the persons in the friendlist
     */
	public String listOfFriends()
	{
		String str = "";
		Node current = first.getNext();
		while (current.getPerson() != null)
		{
			str += current.getPerson().getName() + " ";
			current = current.getNext();
		}
		return str;
	}
}

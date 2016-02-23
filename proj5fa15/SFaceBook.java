package proj5fa15;

/**
 * Title: SFacebook.java
 * Description: Contains the methods for creating a SFacebook object, 
 * 				using the thePeople array to store and modify person objects,
 * 			    and displaying the contents of the array.
 *
 * @author Saad Ahmad
 */

public class SFaceBook
{
	//instance variables
	private Person[] thePeople;
	private int count;

	/** Default constructor - 
	 * Initializes thePeople to a array of length 10 and count to 0 
	 * */
	public SFaceBook()
	{
		thePeople = new Person[10];
		count = 0;
	}

	/**
     * add - Adds a Person to thePeople. Expands array if full.
     *
     * @param name the string name of the Person to be added
     * @param sLvl 1 for visibility of friends of friends, 0 for immediate friends only
     */
	public void add(String name, int sLvl)
	{
		// expand capacity if array is full
		if (count == thePeople.length)
		{
			Person[] temp = new Person[count * 2];
			for (int i = 0; i < count; i++)
			{
				temp[i] = thePeople[i];
			}
			thePeople = temp;
		}

		thePeople[count] = new Person(name, sLvl);
		count++;
	}

	/**
     * friend - adds the two people in each other's friend list
     *
     * @param name1 String name of first person
     * @param name2 String name of other person
     */
	public void friend(String name1, String name2)
	{
		//if not friending self
		if (!name1.equals(name2))
		{
			Person user1 = findFriend(name1);
			Person user2 = findFriend(name2);
			user1.addFriend(user2);
			user2.addFriend(user1);
		}
	}

	 /**
     * unfriend - removes the two people from each other's friend list
     *
     * @param name1 String name of first person
     * @param name2 String name of other person
     */
	public void unfriend(String name1, String name2)
	{
		//if not unfriending self
		if (!name1.equals(name2))
		{
			Person user1 = findFriend(name1);
			Person user2 = findFriend(name2);
			user1.unfriend(user2);
			user2.unfriend(user1);
		}
	}
	
	/**
     * getFriends - Returns the friend list of the person
     *
     * @param name String name of person whose friend list will be displayed
     * @return String string containing names of person's friends
     */
	public String getFriends(String name)
	{
		return name + " is friends with: " + findFriend(name).getFriends();
	}
	
	/**
     * getFriendsByLevel - Returns the friends and friends of friends of a person
     *
     * @param name String name of person whose friend list will be displayed
     * @return String string containing names of person's friends and his friends of friends
     */
	public String getFriendsByLevel(String name)
	{
		return findFriend(name).getFriendsByLevel();
	}
	
	/**
     * friendStatus - Checks for friendship between two Persons
     *
     * @param name1 String name of first person
     * @param name2 String name of other person
     * @return boolean true if 1 is friends with 2, false otherwise
     */
	public boolean friendStatus(String name1, String name2)
	{
		return findFriend(name1).friendsWith(findFriend(name2));
	}
	
	/**
     * toString - Returns the immediate friends of everyone in thePeople
     *
     * @return String a string containing names of all peoples' friends
     */
	public String toString()
	{
		String str = "";
		for (int i = 0; i < count; i++)
		{
			str += thePeople[i].getName() + " is friends with: " + thePeople[i].getFriends() + "\n";
		}
		return str;
	}
	
	/**
     * findFriend - Searches for a Person by checking for name and returns a reference to the Person
     *
     * @param target the String name of the Person to be searched
     * @return String a reference to the Person object if found
     * @throws FriendNotFoundException if person id not found
     */
	private Person findFriend(String target)
	{
		for (int i = 0; i < count; i++)
        {
            if (thePeople[i].getName().equals(target))
            {
                return thePeople[i];
            }
        }
        throw new FriendNotFoundException("User not found for the given name.\n");
	}
}

package proj5fa15;

/**
 * Title: Person.java
 * Description: Stores the name, security level and reference to a friendList object.
 * 				Contains methods to use and modify friendList object.
 *
 * @author Saad Ahmad
 */

public class Person
{
	//instance variables
	private String name;
	private int securityLevel;
	private FriendList friends;

	/**
     * parameterized constructor - Initializes name and security to the specified 
     * 								argument values and initializes a FriendList 
     * 								object for the Person.
     *
     * @param nam String name of the Person
     * @param sLvl 1 for visibility of friends of friends, 0 for immediate friends only
     */
	public Person(String nam, int sLvl)
	{
		name = nam;
		securityLevel = sLvl;
		friends = new FriendList();
	}

	 /**
     * getName - Returns the Person's name.
     *
     * @return String name of the Person
     */
	public String getName()
	{
		return name;
	}

	/**
     * addFriend - Adds a Person to the friend list.
     *
     * @param user the Person to be befriended
     */
	public void addFriend(Person user)
	{
		friends.addToFront(user);
	}

	/**
     * unfriend - Removes the Person from the friend list.
     *
     * @param target the Person to be unfriended
     */
	public void unfriend(Person target)
	{
		//if (friendsWith(target))
			friends.remove(target);
		//else
			//throw new FriendNotFoundException("These two people are already not friends.\n");
	}

	/**
     * friendsWith - Checks if target person is in the person's friend list.
     *
     * @param target the Person to be searched
     * @return boolean true if friends, false otherwise
     */
	public boolean friendsWith(Person target)
	{
		return friends.search(target);
	}

	/**
     * getFriends - Returns the friend list of a Person.
     *
     * @return String the friends of the Person
     */
	public String getFriends()
	{
		return friends.listOfFriends();
	}

	/**
     * getFriendsByLevel - Returns the person's friends and/or friends of friends 
     * 					   of a depending on his/her security level.
     *
     * @return String a string containing list of the immediate friends only if 
     * 			security level is 0, otherwise friends of friends also
     */
	public String getFriendsByLevel()
	{
		if (securityLevel == 0)
		{
			return name + " is friends with: " + getFriends() + "\n";
		}

		String frnList = name + " is friends with: " + getFriends();
		friends.resetList();
		Person temp;
		for(int i = 0; i < friends.size(); i++)
		{
			temp = friends.getNextPerson();
			frnList += "and\n" + temp.name + " is friends with: " + temp.getFriends(); 
		}
		return frnList + "\n";
	}

	/**
     * equals - Determines if two Person objects are equal by comparing names (names are considered unique).
     *
     * @param target a reference to a Person object
     * @return boolean true if two Persons have the same name, otherwise false
     */
	public boolean equals(Person target)
	{
		return this.name.equals(target.name);
	}
}

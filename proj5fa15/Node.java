package proj5fa15;

/**
 * Title: Node.java
 * Description: Defines a node class capable of storing a reference to a Person object 
 * 				and a reference to the next node in a linked list. 
 * 				Accessor and mutator methods are defined for both.
 *
 * @author Saad Ahmad
 */

public class Node
{
	//instance variables
	private Person data;
	private Node next;

	/**
     * parameterized constructor - Initializes data to the specified Person reference,
     * 							   next is set to null.
     *
     * @param p1 the Person reference to be stored in the node
     */
	public Node(Person p1)
	{
		data = p1;
		next = null;
	}


    /**
     * parameterized constructor - Initializes data and next to specified values.
     *
     * @param p1 the Person reference to be stored in the node
     * @param n1  the reference to the next node in the list
     */
	public Node (Person p1, Node n1)
	{
		data = p1;
		next = n1;
	}

	 /**
     * setPerson - Stores a new Person reference in data.
     *
     * @param p1 the Person reference to be stored in the node
     */
	public void setPerson(Person p1)
	{
		data = p1;
	}

	/**
     * setNext - Stores a new Node reference in next.
     *
     * @param n1 the Node reference to be stored in next
     */
	public void setNext(Node n1)
	{
		next = n1;
	}

	/**
     * getPerson - Returns the Person reference stored in data.
     *
     * @return Person a reference to the data stored in the node
     */
	public Person getPerson()
	{
		return data;
	}

	/**
     * getNext - Returns the Node reference stored in next.
     *
     * @return Node the Node reference stored in next
     */
	public Node getNext()
	{
		return next;
	}
}

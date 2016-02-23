package proj5fa15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Title: Proj5App.java
 * Description: The application class creates a SfBook object. 
 * 				Reads the data file and processes inputs accordingly
 * 				and displaying results after process.
 *
 * @author Saad Ahmad
 */

public class Proj5App
{
	public static void main(String[] args) throws FileNotFoundException
	{
		SFaceBook fBook = new SFaceBook();
		Scanner sc = new Scanner(new File("facebookData.txt"));

		String[] splitLine = sc.nextLine().split(" ", 3); //.split from java.lang.String.*
		String action = splitLine[0];
		String person1;
		while (!action.equals("X"))
		{
			person1 = splitLine[1];
			if (action.equals("P"))
			{
				System.out.println("Process: " + action + " " + person1 + " " + splitLine[2]);

				int secLevel = Integer.parseInt(splitLine[2]);
				fBook.add(person1, secLevel);
				System.out.println("++Post process status++\n" + fBook.toString());
			}
			else if (action.equals("F"))
			{
				try
				{
					System.out.println("Process: " + action + " " + person1 + " " + splitLine[2]);
					fBook.friend(person1, splitLine[2]);
					System.out.println("++Post process status++\n" + fBook.toString());

				} 
				catch (FriendNotFoundException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			else if (action.equals("U"))
			{
				try
				{
					System.out.println("Process: " + action + " " + person1 + " " + splitLine[2]);
					fBook.unfriend(person1, splitLine[2]);
					System.out.println("++Post process status++\n" + fBook.toString());
				} 
				catch (FriendNotFoundException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			else if (action.equals("L"))
			{
				try
				{
					System.out.println("Process: " + action + " " + person1);
					System.out.println("++" + person1 + "'s friendlist++\n"+ 
											fBook.getFriends(person1) + "\n");
				} 
				catch (FriendNotFoundException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			else if (action.equals("Q"))
			{
				try
				{
					System.out.println("Process: " + action + " " + person1 + " " + splitLine[2]);
					if (fBook.friendStatus(person1, splitLine[2]))
					{
						System.out.println(person1 + " and " + splitLine[2] + " are friends.\n");
					}
					else
					{
						System.out.println(person1 + " and " + splitLine[2] + " are not friends.\n");
					}
				} 
				catch (FriendNotFoundException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			else if (action.equals("V"))
			{
				try
				{
					System.out.println("Process: " + action + " " + person1);
					System.out.println("++" + person1 + "'s friends and friends of friends++\n" +
													fBook.getFriendsByLevel(person1));
				} 
				catch (FriendNotFoundException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			splitLine = sc.nextLine().split(" ", 3);
			action = splitLine[0];
		}
		sc.close();
	}
}
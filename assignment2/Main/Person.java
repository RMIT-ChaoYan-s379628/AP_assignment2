
/*
 * Author:Chao Yan	
 * Date: 22/3/2018
 * Introduction: Person define a class of all the person in the game,
 * includeing Adult and Child.
 * for all Person. 
 */
package assignment1;

import java.util.*;

public class Person {
	public String Name;
	public int Age;
	public String Status;
	public String photo;
	/* This is the list of every person has his/her friends. */
	public List<Person> Friends = new ArrayList();

	/* Construction method,including name and age to construct a person */
	public Person() {

	}

	/* Construction method,including name and age to construct a person */
	public Person(String Name, int Age) {
		this.Name = Name;
		this.Age = Age;
	}

	/* the set/get method of the name */
	public String getName() {
		return Name;
	}

	/* the set/get method of the name */
	public void setName(String Name) {
		this.Name = Name;
	}

	/* the set/get method of the age */
	public int getAge() {
		return Age;
	}

	/* the set/get method of the age */
	public void setAge(int Age) {
		this.Age = Age;
	}

	/* the set/get method of the status */
	public String getStatus() {
		return Status;
	}

	/* the set/get method of the status */
	public void setStatus(String Status) {
		this.Status = Status;
	}

	/* the set/get method of the photo */
	public String getPhoto() {
		return photo;
	}

	/* the set/get method of the photo */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/* the set/get method of the all information */
	public void showProfile() {
		this.getName();
		this.getAge();
		this.getStatus();
		System.out.print("Name: " + Name + ", Age: " + Age + ", Status: " + Status + ", Photo: " + photo);

	}
	public String showProfile_string() {
		this.getName();
		this.getAge();
		this.getStatus();
		return " Age: " + Age + "\n Status: " + Status + "\n Photo: " + photo;

	}

	/* the set/get method of the friend list */
	public void showFriends() {
		System.out.println("Friends List :");
		for (int i = 0; i < Friends.size(); i++) {
			System.out.println(i + 1 + ". " + Friends.get(i).Name);
		}
	}
	
	public String showFriends_string() {
		String name="Friend List :"+"\n";
		for (Person p: this.Friends){
			
		 name+= p.getName()+"\n";
		}
		return name;
	}
	
	/* the set/get method of the children */
	public void showChildren() {

	}
	public String showChildren_string(){
		return "";
	}

	/* the set/get method of the parents */
	public void showParents() {

	}
	public String showParents_string(){
		return "";
	}
}

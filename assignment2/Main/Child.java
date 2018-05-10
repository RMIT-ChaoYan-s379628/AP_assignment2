/*
 *  Author:Meng Gao	
 * Date: 22/3/2018
 * Introduction: Child define a class of all the Children in the Net,
 * inherit from Person.
 * for all Children. 
 */

package assignment1;

import java.util.ArrayList;
import java.util.List;

/* Inherit from Person,include Name and Age*/
public class Child extends Person {
	public Child(String Name, int Age) {
		super(Name, Age);
	}

	/* This is the list of every person has his/her friends. */
	public List<Person> Parents = new ArrayList();

	/* the set/get method of the Parents list */
	public void showParents() {
		System.out.println("Parents List :");
		for (int i = 0; i < Parents.size(); i++) {
			System.out.println(i + 1 + ". " + Parents.get(i).Name);
		}
	}
	public String showParents_string() {
		String name="Parent List :"+"\n";
		for (Person p: this.Parents){
			
		 name+= p.getName()+"\n";
		}
		return name;
}
	}

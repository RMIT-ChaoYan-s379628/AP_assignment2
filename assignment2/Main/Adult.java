/*
 * Author:Meng Gao	
 * Date: 22/3/2018
 * Introduction: Adult define a class of all the Adult in the Net,
 * inherit from Person.d.
 * for all Person. 
 */

package Main;

import java.util.*;

/* Inherit from Person,include Name and Age*/
public class Adult extends Person {
	public Adult(String Name, int Age) {
		super(Name, Age);
	}

	/* This is the list of every person has his/her Children. */
	public List<Person> Children = new ArrayList();

	/* the set/get method of the Children list */
	public void showChildren() {
		System.out.println("Children List :");
		for (int i = 0; i < Children.size(); i++) {
			System.out.println(i + 1 + ". " + Children.get(i).Name);
		}
	}
	public String showChildren_string() {
		String name="Children List :"+"\n";
		for (Person p: this.Children){
			
		 name+= p.getName()+"\n";
		}
		return name;
	}
}
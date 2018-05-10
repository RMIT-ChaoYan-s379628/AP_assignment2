/*
 * Author:Chao Yan	
 * Date: 22/3/2018
 * Introduction: Driver define a class of all the driver methods for all types of classes in the Net,
 * including Adult and Child.
 * for all Person. 
 */
package assignment1;

import java.util.*;

public class Driver {
	private static List<Person> net = new ArrayList<Person>();
	private static Person chosenOne = null;
	private static Adult chosenParent = null;
	private static Child chosenChild = null;
	private static int Check = 0;

	/* The set of simple data with 6 Adults and 3 children */
	public void set() {
   
		Adult A = new Adult("A", 24);
		Adult B = new Adult("B", 21);
		Adult C = new Adult("C", 27);
		Adult D = new Adult("D", 28);
		Adult E = new Adult("E", 29);
		Adult F = new Adult("F", 34);
		Child G = new Child("G", 16);
		Child H = new Child("H", 1);
		Child I = new Child("I", 13);
		A.Friends.add(B);
		B.Friends.add(A);
		B.Friends.add(C);
		C.Friends.add(B);
		C.Friends.add(D);
		D.Friends.add(C);
		D.Friends.add(E);
		E.Friends.add(D);
		E.Friends.add(F);
		F.Friends.add(E);
		net.add(A);
		net.add(B);
		net.add(C);
		net.add(D);
		net.add(E);
		net.add(F);
		net.add(G);
		net.add(H);
		net.add(I);
	}

	/* the set method of the Person list */
	public void show(List<Person> net) {
		System.out.println();
		System.out.println("Person list:");
		for (int i = 0; i < net.size(); i++) {
			System.out.print(i + 1 + ". ");
			net.get(i).showProfile();
			;
			System.out.println();
		}
		this.process(net);
	}

	/* the set method of person list,determine its existance */
	public void check_existed(List<Person> net, String name) {
		boolean exsited = false;
		for (int i = 0; i < net.size(); i++) {
			if (name.equals(net.get(i).Name)) {
				exsited = true;
			}
		}
	}

	/*
	 * the add method of the Adult list, construction method including net and
	 * Name
	 */
	public void addAdult(List<Person> net) {
		System.out.println();
		System.out.println("Please insert name and age.");
		Scanner reader = new Scanner(System.in);
		String Name = reader.nextLine();
		boolean exsited = false;
		this.check_existed(net, Name);
		if (exsited) {
			System.out.println();
			System.out.println("The name has been exsited.");
			System.out.println("Please insert right parents' name. ");
			System.out.println();
			this.addAdult(net);
		} else {
			int Age = reader.nextInt();
			if (Age < 18) {
				System.out.println();
				System.out.println("You are a child.");
				System.out.println("Please choose again.");
				System.out.println();
				this.process_age(net);
			}
			Adult newUser = new Adult(Name, Age);
			net.add(newUser);
			this.show(net);
			this.process(net);
		}
	}

	/* the set/get method of the addParents list */
	public void addParents(List<Person> net) {
		Scanner reader = new Scanner(System.in);
		System.out.println();
		System.out.println("Please insert one of your parent's Name");
		String parentName_a = reader.nextLine();
		for (int i = 0; i < net.size(); i++) {
			if (parentName_a.equals(net.get(i).Name)) {
				chosenChild.Parents.add(net.get(i));
				chosenParent = (Adult) net.get(i);
				chosenParent.Children.add(chosenChild);
				Check = Check + 1;
			}
		}
	}

	/* the set method of the Person list */
	public void check(List<Person> net) {
		Check = 0;
		do {
			this.addParents(net);
		} while (Check < 2);
	}

	/* the set method of determining in the each Person list */
	public boolean check_parents(List<Person> net) {
		boolean correct = false;
		Person parent_a = chosenChild.Parents.get(0);
		Person parent_b = chosenChild.Parents.get(1);
		for (int i = 0; i < parent_b.Friends.size(); i++) {
			if (parent_a.Name.equals(parent_b.Friends.get(i).Name)) {
				correct = true;
			}
		}
		return correct;
	}

	/*
	 * Construction method,including net to construct check list, check insert
	 * clarification
	 */
	public void final_check(List<Person> net) {

		this.check(net);
		this.check_parents(net);

		while (this.check_parents(net) == false | chosenParent.Age < 18) {
			System.out.println();
			System.out.println("Please insert right parents' name. ");
			System.out.println();
			this.check(net);
		}
		System.out.println();
		chosenChild.showParents();
		System.out.println();
	}

	/* the set method of addchild in Person list，Construction scanner */
	public void addChild(List<Person> net) {
		System.out.println();
		System.out.println("Please insert name and age.");
		Scanner reader = new Scanner(System.in);
		String Name = reader.nextLine();
		boolean exsited = false;
		this.check_existed(net, Name);
		if (exsited) {
			System.out.println();
			System.out.println("The name has been exsited.");
			System.out.println("Please insert right parents' name. ");
			System.out.println();
			this.addChild(net);
		} else {
			int Age = reader.nextInt();
			if (Age >= 18) {
				System.out.println();
				System.out.println("You are an adult.");
				System.out.println("Please choose again.");
				System.out.println();
				this.process_age(net);
			}
			Child newUser = new Child(Name, Age);
			chosenChild = newUser;
			net.add(newUser);
			this.final_check(net);
			this.process(net);
		}
	}

	/* the set method of process_age in the Person list, Invoke data */
	public void process_age(List<Person> net) {
		try {
			System.out.println();
			System.out.println("Are you an adult?");
			System.out.println("1. Yes. ");
			System.out.println("2. No. ");
			System.out.println("3. Back to the main menu. ");
			System.out.println("4. Exit. ");
			System.out.println();
			System.out.print("Enter an option:");
			Scanner reader = new Scanner(System.in);
			int option = reader.nextInt();
			switch (option) {
			case 1:
				this.addAdult(net);
				break;
			case 2:
				this.addChild(net);
				break;
			case 3:
				this.process(net);
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Your input is wrong!");
				process_age(net);
			}
		} catch (Exception e) {
			System.out.println("Your input is wrong!");
			process_age(net);
		}
	}

	/* the set method of process_age in the Person list,Construction Scanner */
	public void deletePerson(List<Person> net) {
		System.out.println();
		System.out.println("Person list:");
		for (int i = 0; i < net.size(); i++) {
			System.out.print(i + 1 + ". ");
			net.get(i).showProfile();
			;
			System.out.println();
		}
		System.out.println();
		System.out.println("Please insert name.");
		Scanner reader = new Scanner(System.in);
		String name = reader.nextLine();
		for (int i = 0; i < net.size(); i++) {
			if (name.equals(net.get(i).Name)) {
				net.remove(i);
				Check = 1;
			}
		}
		for (int i = 0; i < net.size(); i++) {
			for (int j = 0; j < net.get(i).Friends.size(); j++) {
				if (name.equals(net.get(i).Friends.get(j).Name)) {
					net.get(i).Friends.remove(j);
				}
			}
		}

	}

	/* the set method of check_delete in the Person list, Invoke data */
	public void check_delete(List<Person> net) {
		this.deletePerson(net);
		do {
			if (Check == 0) {
				System.out.println();
				System.out.println("The person cannot be found.");
				System.out.println("Plesase insert the right name.");
				System.out.println();
				this.deletePerson(net);

			} else {
				break;
			}

		} while (Check == 0);
		process(net);
	}

	/*
	 * the set method of choose in the Person list, construction Scanner and
	 * method including Name
	 */
	public void choose(List<Person> net) {
		System.out.println();
		System.out.println("Person list:");
		for (int i = 0; i < net.size(); i++) {

			System.out.print(i + 1 + ". ");
			net.get(i).showProfile();
			;
			System.out.println();
		}
		System.out.println("Please choose a person.");
		Scanner reader = new Scanner(System.in);
		String name = reader.nextLine();
		for (int i = 0; i < net.size(); i++) {
			if (name.equals(net.get(i).Name)) {
				Check = 1;
				chosenOne = net.get(i);
				System.out.println();
				net.get(i).showFriends();
				System.out.println();
				net.get(i).showParents();
				System.out.println();
				net.get(i).showChildren();
				System.out.println();

			}
		}

	}

	/* the set method of check_person in the Person list, Invoke data */
	public void check_person(List<Person> net) {
		this.choose(net);
		do {
			if (Check == 0) {
				System.out.println();
				System.out.println("The person cannot be found.");
				System.out.println("Plesase insert the right name.");
				System.out.println();
				this.choose(net);

			} else {
				break;
			}

		} while (Check == 0);
		process_submenu(net);
	}

	/*
	 * the set method of addFriend_child in the Person list, construction
	 * Scanner and method including friend_name, invoke data
	 */
	public void addFriend_child(List<Person> net) {
		System.out.println();
		System.out.println("Please insert friend's name.");
		Scanner reader = new Scanner(System.in);
		String friend_name = reader.nextLine();
		do {
			Check = 0;
			for (int i = 0; i < net.size(); i++) {
				if (friend_name.equals(net.get(i).Name)) {
					Check = 1;
				}
			}
			if (Check == 0) {
				System.out.println();
				System.out.println("The person cannot be found.");
				System.out.println("Plesase insert the right name.");
				System.out.println();
				this.addFriend_child(net);
			} else {
				break;
			}

		} while (Check == 0);

		for (int j = 0; j < net.size(); j++) {
			if (friend_name.equals(net.get(j).Name)) {
				int age_diff = Math.abs(chosenOne.getAge() - net.get(j).getAge());
				if (net.get(j).getAge() >= 18) {
					net.get(j).Friends.add(chosenOne);
					chosenOne.Friends.add(net.get(j));
					chosenOne.showFriends();
					this.process(net);
				} else if (net.get(j).getAge() <= 2) {
					System.out.println();
					System.out.println("Sorry, baby cannot be added as a friend.");
					System.out.println();
					this.addFriend_child(net);

				} else {
					if (age_diff <= 3) {
						net.get(j).Friends.add(chosenOne);
						chosenOne.Friends.add(net.get(j));
						chosenOne.showFriends();
						this.process(net);
						;
					} else {
						System.out.println();
						System.out.println("Sorry, your age gap need be less than 3 years.");
						System.out.println();
						this.addFriend_child(net);

					}
				}
			}
		}

	}

	/*
	 * the set method of add_Friend in the Person list, construction Scanner and
	 * method including friend_name
	 */
	public void addFriend(List<Person> net) {
		System.out.println();
		System.out.println("Please insert friend's name.");
		System.out.println();
		Scanner reader = new Scanner(System.in);
		String friend_name = reader.nextLine();
		do {
			Check = 0;
			for (int i = 0; i < net.size(); i++) {
				if (friend_name.equals(net.get(i).Name)) {
					Check = 1;
				}
			}
			if (Check == 0) {
				System.out.println();
				System.out.println("The person cannot be found.");
				System.out.println("Plesase insert the right name.");
				System.out.println();
				this.addFriend(net);

			} else {
				break;
			}

		} while (Check == 0);
		if (friend_name.equals(chosenOne.Name)) {
			System.out.println();
			System.out.println("You cannot add yourself as a friend.");
			System.out.println("Please insert another name.");
			System.out.println();
			this.addFriend(net);
		} else {
			for (int j = 0; j < net.size(); j++) {
				if (friend_name.equals(net.get(j).Name)) {
					net.get(j).Friends.add(chosenOne);
					chosenOne.Friends.add(net.get(j));
					chosenOne.showFriends();
				}
			}
			this.process(net);
		}
	}

	/*
	 * the set method of check_friendlist in the Person list, clarify its
	 * existence
	 */
	public void check_friendlist(List<Person> net) {
		boolean hasfriend = chosenOne.Friends.size() > 0;
		if (!hasfriend) {
			System.out.println();
			System.out.println("There is no peopole in the friend list.");
			System.out.println("Please choose another options.");
			System.out.println();
			this.process_submenu(net);
		} else {
			this.deleteFriend(net);
		}
	}

	/*
	 * the set method of deleteFriend in the Person list, construction Scanner
	 * and method including friend_name,invoke data
	 */
	public void deleteFriend(List<Person> net) {
		System.out.println();
		System.out.println("Please insert friend's name.");
		System.out.println();
		Scanner reader = new Scanner(System.in);
		String friend_name = reader.nextLine();
		for (int j = 0; j < net.size(); j++) {
			if (friend_name.equals(net.get(j).Name)) {
				net.get(j).Friends.remove(chosenOne);
				chosenOne.Friends.remove(net.get(j));
				chosenOne.showFriends();
			}
		}
		this.process(net);
	}

	/* the set/get method of the Menu */
	public void displayMenu() {
		System.out.println();
		System.out.println("The menu: ");
		System.out.println("1. List everyone");
		System.out.println("2. Add a person");
		System.out.println("3. Delete a person");
		System.out.println("4. Choose a person");
		System.out.println("5. Exit");
		System.out.println();
		System.out.print("Enter an option:");
	}

	/* the set/get method of the Submenu */
	public void displaySubmenu() {
		System.out.println();
		System.out.println("The menu: ");
		System.out.println("1. Add Friend");
		System.out.println("2. Delete Friend");
		System.out.println("3. Back to Main Menu");
		System.out.println("4. Exit");
		System.out.println();
	}

	/* the set/get method of the submenu, construction Scanner, invoke data */
	public void process_submenu(List<Person> net) {
		try {
			displaySubmenu();
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				if (chosenOne.getAge() >= 18) {
					this.addFriend(net);
				} else {
					this.addFriend_child(net);
				}
				break;
			case 2:
				this.check_friendlist(net);
				break;
			case 3:
				this.process(net);
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println();
				System.out.println("Your input is wrong!");
				System.out.println();
				process_submenu(net);
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Your input is wrong!");
			System.out.println();
			process_submenu(net);
		}
	}

	/* the set/get method of the Person, construction Scanner, invoke data */
	public void process(List<Person> net) {
		try {
			this.displayMenu();
			Scanner reader = new Scanner(System.in);
			int option = reader.nextInt();
			switch (option) {
			case 1:
				this.show(net);
				break;
			case 2:
				this.process_age(net);
				break;
			case 3:
				this.check_delete(net);
				break;
			case 4:
				this.check_person(net);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println();
				System.out.println("Your input is wrong!");
				System.out.println();
				process(net);
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Your input is wrong!");
			System.out.println();
			process(net);
		}
	}

	/* construction Method */
	public void begin() {
		this.set();
		this.process(net);
	}

}

package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Exception.NoAvailableException;
import Exception.NoParentException;
import Exception.NoSuchAgeException;
import Exception.NotToBeClassmatesException;
import Exception.NotToBeColleaguesException;
import Exception.NotToBeCoupledException;
import Exception.NotToBeFriendsException;
import Exception.TooYoungException;

public class Util {
	private static final int ADULT_LIMIT = 16, CHILD_LIMIT = 3, LIMIT = 150;

	// create person according to the age, the age cannot be changed
	public static Person createPerson(String strName, int nAge, String strImage, String strStatus, String strSex,
			String strState) throws NoSuchAgeException {
		if (LIMIT < nAge) {
			throw new NoSuchAgeException();
		} else if (ADULT_LIMIT < nAge) {
			return new Adult(strName, nAge, strImage, strStatus, strSex, strState);
		} else if (CHILD_LIMIT <= nAge) {
			return new Child(strName, nAge, strImage, strStatus, strSex, strState);
		} else if (0 < nAge) {
			return new YoungChild(strName, nAge, strImage, strStatus, strSex, strState);
		} else {
			throw new NoSuchAgeException();
		}
	}

	public static String encodePerson(Person person) {
		if (null == person)
			return "";
		return person.getName() + ", \"" + person.getImage() + "\"" + ", \"" + person.getStatus() + "\", "
				+ person.getSex() + ", " + person.getAge() + ", " + person.getState();
	}

	public static Person decodePerson(String strPerson) throws NumberFormatException, NoSuchAgeException {
		if (null == strPerson)
			return null;
		ArrayList<String> lstInfo = new ArrayList<String>();
		String strItem = "";
		char cItem;
		for (int nIndex = 0; nIndex < strPerson.length(); nIndex++) {
			cItem = strPerson.charAt(nIndex);
			if (',' == cItem) {
				lstInfo.add(strItem.trim());
				strItem = "";
			} else if ('\"' == cItem) {
				continue;
			} else {
				strItem += cItem;
			}
		}
		lstInfo.add(strItem.trim());
		return createPerson(lstInfo.get(0), Integer.parseInt(lstInfo.get(4)), lstInfo.get(1), lstInfo.get(2),
				lstInfo.get(3), lstInfo.get(5));
	}

	public static String[] decodeRelation(String strRelation) throws NumberFormatException, NoSuchAgeException {
		if (null == strRelation)
			return null;
		String[] lstInfo = new String[3];
		String strItem = "";
		int index = 0;
		char cItem;
		for (int nIndex = 0; nIndex < strRelation.length(); nIndex++) {
			cItem = strRelation.charAt(nIndex);
			if (',' == cItem) {
				lstInfo[index] = strItem.trim();
				index++;
				strItem = "";
			} else {
				strItem += cItem;
			}
		}
		lstInfo[index] = strItem.trim();
		return lstInfo;
	}

	public static LinkedList<Person> readPersonFromFile()
			throws FileNotFoundException, NumberFormatException, NoSuchAgeException {
		LinkedList<Person> person = new LinkedList<Person>();
		Scanner input = new Scanner(new File("people.txt"));
		while (input.hasNextLine()) {
			Person temp = decodePerson(input.nextLine());
			person.add(temp);
		}
		input.close();
		return person;
	}

	public static void readRelationFromFile(LinkedList<Person> people, RelationShipManager manager)
			throws FileNotFoundException, NumberFormatException, NoSuchAgeException {
		Scanner input = new Scanner(new File("relation.txt"));
		while (input.hasNextLine()) {
			String[] lstInfo = decodeRelation(input.nextLine());
			Person first = null;
			Person second = null;
			for (int i = 0; i < people.size(); i++) {
				if (people.get(i).getName().equals(lstInfo[0])) {
					first = people.get(i);
				} else if (people.get(i).getName().equals(lstInfo[1])) {
					second = people.get(i);
				}
			}
			if (first != null && second != null) {
				try {
					manager.addRelationShip(first, second, lstInfo[2]);
				} catch (TooYoungException | NotToBeFriendsException | NotToBeCoupledException | NoAvailableException
						| NotToBeColleaguesException | NotToBeClassmatesException | NoParentException e) {
					continue;
				}
			}
		}
		input.close();
	}

	public static void writePersonToFile(LinkedList<Person> people) throws IOException {
		File file = new File("people.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		PrintWriter output = new PrintWriter(new FileWriter(file));
		for (int i = 0; i < people.size(); i++) {
			output.println(encodePerson(people.get(i)));
		}
		output.flush();
		output.close();
	}

	public static void writeRelationToFile(RelationShipManager manager) throws IOException {
		File file = new File("relation.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		PrintWriter output = new PrintWriter(new FileWriter(file));
		System.out.println(manager.getRelations().size());
		for (int i = 0; i < manager.getRelations().size(); i++) {
			Person first = manager.getRelations().get(i).getFirstPerson();
			Person second = manager.getRelations().get(i).getSecondPerson();
			String type = manager.checkRelationShip(first, second);
			output.println(first.getName() + ", " + second.getName() + ", " + type);
		}
		output.flush();
		output.close();
	}
}

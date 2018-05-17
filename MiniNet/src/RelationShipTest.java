
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Main.FriendShip;
import Main.Person;
import Main.RelationShip;

import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class RelationShipTest {
	Person one;
	Person two;
	Person three;
	RelationShip relation;

	public RelationShipTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		one = new Person("Lucy", 6, "", "", "F", "VIC");
		two = new Person("Candy", 7, "", "", "F", "VIC");
		three = new Person("Lucas", 8, "", "", "M", "WA");
		relation = new FriendShip(one, two);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getFirstPerson method, of class RelationShip.
	 */
	@Test
	public void testGetFirstPerson() {
		System.out.println("getFirstPerson");
		Person expResult = one;
		Person result = relation.getFirstPerson();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getSecondPerson method, of class RelationShip.
	 */
	@Test
	public void testGetSecondPerson() {
		System.out.println("getSecondPerson");
		Person expResult = two;
		Person result = relation.getSecondPerson();
		assertEquals(expResult, result);
	}

	/**
	 * Test of hasPerson method, of class RelationShip.
	 */
	@Test
	public void testHasPerson() {
		System.out.println("hasPerson");
		boolean expResult = false;
		boolean result = relation.hasPerson(three);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getAnotherPerson method, of class RelationShip.
	 */
	@Test
	public void testGetAnotherPerson() {
		System.out.println("getAnotherPerson");
		Person expResult = one;
		Person result = relation.getAnotherPerson(two);
		assertEquals(expResult, result);
	}

}

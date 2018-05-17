package Main;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: ColleagueShip define a class of all the colleagueship in the
 *                Net, inherit from Relationship.
 */
public class ColleagueShip extends RelationShip {

	/* Inherit from RelationShip,include person1 and person2 */
	public ColleagueShip(Person person1, Person person2) {
		super(person1, person2);
	}

}

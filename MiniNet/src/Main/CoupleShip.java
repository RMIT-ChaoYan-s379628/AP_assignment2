package Main;

/**
 * @author:Meng Gao
 * @date: 17/5/2018
 * @introduction: CoupleShip define a class of all the coupleship in the Net,
 * inherit from Relationship.
 */
public class CoupleShip extends RelationShip {

    /* Inherit from RelationShip,include person1 and person2*/
    public CoupleShip(Person person1, Person person2) {
        super(person1, person2);
    }

}

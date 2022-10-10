/**
* Class for a generic person magical or muggle
*
* @author cproenza3
* @version 1
*/
public class Person {
    private String name;

    /**
    * Constructor representing a person
    * @param name is the person's name
    */
    public Person(String name) {
        this.name = name;
    }

    /**
    * Getter for name
    * @return the name of the person
    */
    public String getName() {
        return name;
    }

    /**
    * Contains text needed for code reusability
    * @return the reusable string
    */
    public String myName() {
        return "My name is " + name + " and I am ";
    }

    @Override
    public String toString() {
        return "My name is " + name;
    }
}
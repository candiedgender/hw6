/**
* Class for a muggle
*
* @author cproenza3
* @version 1
*/
public class Muggle extends Person {
    private String occupation;

    /**
    * Constructor for a Muggle
    * @param name is the Muggle's name
    * @param occupation is the Muggle's occupation
    */
    public Muggle(String name, String occupation) {
        super(name);
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return myName() + "a(n) " + occupation + ".";
    }
}
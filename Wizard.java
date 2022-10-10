/**
* Class for a wizard
*
* @author cproenza3
* @version 1
*/
public class Wizard extends Person implements Magical, Comparable<Wizard> {
    private House house;
    private int skill;
    private String patronus;

    /**
    * Constructor for a wizard
    * @param name is the wizard's name
    * @param house is the house they're in
    * @param skill is their integer skill number
    * @param patronus is their patronus
    */
    public Wizard(String name, House house, int skill, String patronus) {
        super(name);
        this.house = house;
        this.skill = skill;
        this.patronus = patronus;
    }

    /**
    * Getter for the skill
    * @return the skill
    */
    public int getSkill() { return skill; }

    /**
    * Setter for the skill
    * @param skill is the skill
    */
    public void setSkill(int skill) { this.skill = skill; }

    /**
    * Used if someone is victorious in a duel
    * @param name1 is the name of the winner
    * @param name2 is the name of the loser
    * @return the victory statement
    */
    private String victory(String name1, String name2) {
        return name1 + " triumphed over " + name2 + " in a duel!";
    }

    /**
    * Used if someone is victorious in a duel
    * @param name3 is the name of one of the wizards
    * @param name4 is the name of the other wizard
    * @return the tie statement
    */
    private String tie(String name3, String name4) {
        return name3 + " tied with " + name4 + " in a duel!";
    }

    /**
    * Allows wizards to duel
    * @param w is a wizard
    */
    public void duel(Wizard w) {
        if (this.compareTo(w) > 0) {
            String name1 = this.getName();
            String name2 = w.getName();
            System.out.println(victory(name1, name2));
        } else if (this.compareTo(w) < 0) {
            String name1 = w.getName();
            String name2 = this.getName();
            System.out.println(victory(name1, name2));
        } else {
            String name3 = this.getName();
            String name4 = w.getName();
            System.out.println(tie(name3, name4));
        }
    }

    /**
    * Code reusability for the first part of castSpell
    * @return the string at the beginning of castSpell
    */
    private String cast() {
        return getName() + " casts ";
    }

    @Override
    public void castSpell(String spell) {
        if (spell.equals("expecto patronum")) {
            System.out.println(cast() + spell + " and a "
                + patronus + " patronus appears!");
        } else {
            System.out.println(cast() + spell + "!");
        }
    }

    @Override
    public String toString() {
        return myName() + "a wizard in the "
            + house.toString().charAt(0)
            + house.toString().substring(1).toLowerCase() + " house.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Wizard)) {
            return false;
        }
        Wizard w = (Wizard) o;
        return w.getName().equals(this.getName()) && w.skill == this.skill
        && w.house.equals(this.house) && w.patronus.equals(this.patronus);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        return (31 * hash) + getName().hashCode() + skill
        + patronus.hashCode() + house.hashCode();
    }

    @Override
    public int compareTo(Wizard w) {
        return this.skill - w.skill;
    }
}
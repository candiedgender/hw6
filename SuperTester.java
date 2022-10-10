import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class SuperTester {

    private static final String PEOPLE_ORIGINAL = "HarryG,100,stag%n"
        + "RonG,90,jack russell terrier%n"
        + "HermioneG,20000,otter%n";

    private static final String PEOPLE1_ORIGINAL = "HarryG,100,stag%n"
        + "RonG,90,jack russell terrier%n"
        + "MuggleM%n"
        + "HermioneG,20000,otter%n";

    private static final String PEOPLE2_ORIGINAL = "HarryG,100,stag%n"
        + "RonG,90,jack russell terrier%n"
        + "MuggleM%n"
        + "DracoS,69,nothing%n"
        + "CedricH,103,basset hound%n"
        + "MuggleM%n"
        + "MuggleM%n"
        + "JoshDierbergerR,420,sid from harry potter%n";

    private static final String PEOPLE_EXPECTED = "Welcome to Hogwarts!"
        + " Meet our students:"
        + " [My name is Harry and I am a wizard in"
        + " the Gryffindor house., My name is Ron"
        + " and I am a wizard in the Gryffindor house.,"
        + " My name is Hermione and I am a wizard in the"
        + " Gryffindor house.]";

    private static final String PEOPLE1_EXPECTED = "Welcome to Hogwarts!"
        + " Meet our students:"
        + " [My name is Harry and I am a wizard in"
        + " the Gryffindor house., My name is Ron"
        + " and I am a wizard in the Gryffindor house.,"
        + " My name is Hermione and I am a wizard in the"
        + " Gryffindor house.]";

    private static final String PEOPLE2_EXPECTED = "Welcome to Hogwarts!"
        + " Meet our students:"
        + " [My name is Harry and I am a wizard in"
        + " the Gryffindor house., My name is Ron"
        + " and I am a wizard in the Gryffindor house.,"
        + " My name is Draco and I am a wizard in the"
        + " Slytherin house., My name is Cedric and I"
        + " am a wizard in the Hufflypuff house.,"
        + " My name is JoshDierberger and I am a wizard"
        + " in the Ravenclaw house.]";

    public static void main(String[] args) throws IOException,
        FileNotFoundException, Exception {

        // Reset people.txt, people1.txt, people2.txt
        resetPeopleFiles();

        // Check to make sure that startCeremony works ok
        startCeremonyTest();

        // Check House enum
        houseTest();

        // Check Magical interface
        magicalTest();

        // Check Muggle class
        muggleTest();

        // Check Wizard class
        wizardTest();

        // You get the idea
        imposterAlertExceptionTest();
    }

    private static void resetPeopleFiles() throws IOException,
        FileNotFoundException {

        System.out.println("Writing people.txt");
        PrintStream peoplePrinter = new PrintStream("people.txt");
        peoplePrinter.printf(PEOPLE_ORIGINAL);
        peoplePrinter.close();

        System.out.println("Writing people1.txt");
        PrintStream people1Printer = new PrintStream("people1.txt");
        people1Printer.printf(PEOPLE1_ORIGINAL);
        people1Printer.close();

        System.out.println("Writing people2.txt");
        PrintStream people2Printer = new PrintStream("people2.txt");
        people2Printer.printf(PEOPLE2_ORIGINAL);
        people2Printer.close();

        System.out.println("Done!");
        System.out.println();
    }

    private static void startCeremonyTest() throws Exception{

        System.out.println("Testing startCeremony");
        System.out.println();

        Hogwarts h = new Hogwarts();
        h.startCeremony("people.txt");
        System.out.println("Called startCeremony on people.txt");
        System.out.println("Expected vs. Actual:");
        System.out.println(PEOPLE_EXPECTED);
        System.out.println(h);
        System.out.println();

        Hogwarts h1 = new Hogwarts();
        h1.startCeremony("people1.txt");
        System.out.println("Called startCeremony on people1.txt");
        System.out.println("Expected vs. Actual:");
        System.out.println(PEOPLE1_EXPECTED);
        System.out.println(h1);
        System.out.println();

        Hogwarts h2 = new Hogwarts();
        h2.startCeremony("people2.txt");
        System.out.println("Called startCeremony on people2.txt");
        System.out.println("Expected vs. Actual:");
        System.out.println(PEOPLE2_EXPECTED);
        System.out.println(h2);
        System.out.println();
    }

    private static void houseTest() {

        System.out.println("Testing House");
        System.out.println();
        System.out.println("Iterating over all enum values...");
        House[] houses = House.values();
        for (House house : houses) {
            System.out.println(house.name() + ": " + house);
        }

        System.out.println();
    }

    private static void magicalTest() {

        System.out.println("Testing Magical");
        System.out.println();
        Wizard testWizard = new Wizard("Josh Dierberger",
            House.RAVENCLAW, 420, "sid from toy story");

        System.out.println("Expected vs. Actual:");
        System.out.println("Josh Dierberger casts remove fun from kahoot!");
        testWizard.castSpell("remove fun from kahoot");
        System.out.println();

        System.out.println("Expected vs. Actual:");
        System.out.println("Josh Dierberger casts expecto patronum"
            + " and a sid from toy story patronus appears!");
        testWizard.castSpell("expecto patronum");

        System.out.println();
    }

    private static void muggleTest() {

        System.out.println("Testing Muggle");
        System.out.println();

        Muggle testMuggle = new Muggle("Tony Peng",
            "sit-in-back-of-class TA man");
        System.out.println("Expected vs. Actual:");
        System.out.println("My name is Tony Peng and I am a(n)"
            + " sit-in-back-of-class TA man.");
        System.out.println(testMuggle);

        System.out.println();
    }

    private static void wizardTest() {

        System.out.println("Testing Wizard");
        System.out.println();

        Wizard badWizard = new Wizard("bad",
            House.GRYFFINDOR, 1, "poop emoji");
        Wizard okWizard = new Wizard("ok",
            House.RAVENCLAW, 10, "DVORAK typing scheme");
        Wizard okWizard2 = new Wizard("ok",
            House.GRYFFINDOR, 10, "e pluribus unum");
        Wizard decentWizard = new Wizard("decent",
            House.SLYTHERIN, 10, "a large oven mitt");

        System.out.println("Testing Wizard.duel");
        System.out.println();

        System.out.println("Expected vs. Actual:");
        System.out.println("ok triumphed over bad in a duel!");
        badWizard.duel(okWizard);
        System.out.println();

        System.out.println("Expected vs. Actual:");
        System.out.println("decent tied with ok in a duel!");
        decentWizard.duel(okWizard);
        System.out.println();

        System.out.println("Testing Wizard.equals");
        System.out.println();

        System.out.println("Expected vs. Actual:");
        System.out.println("okWizard == okWizard2: true");
        System.out.println("okWizard == okWizard2: "
            + okWizard.equals(okWizard2));
        System.out.println();

        System.out.println("Testing Wizard.compareTo");
        System.out.println();

        System.out.println("Expected vs. Actual:");
        System.out.println("okWizard.compareTo(badWizard): 1");
        System.out.println("okWizard.compareTo(badWizard): "
            + okWizard.compareTo(badWizard));
        System.out.println();
    }

    private static void imposterAlertExceptionTest() {

        System.out.println("Testing ImposterAlertException");
        System.out.println();

        ImposterAlertException e = new ImposterAlertException("Ew, a muggle!");

        System.out.println("Expected vs. Actual:");
        System.out.println("Ew, a muggle!");
        System.out.println(e.getMessage());
    }
}
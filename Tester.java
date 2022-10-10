import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Tester {

    private static final String peopleOriginal =
        "HarryG,100,stag%n" +
        "RonG,90,jack russell terrier%n" +
        "HermioneG,20000,otter%n";

    private static final String people1Original =
        "HarryG,100,stag%n" +
        "RonG,90,jack russell terrier%n" +
        "MuggleM%n" +
        "HermioneG,20000,otter%n";

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream peoplePrinter = new PrintStream("people.txt");
        peoplePrinter.printf(peopleOriginal);
        peoplePrinter.close();

        PrintStream people1Printer = new PrintStream("people1.txt");
        people1Printer.printf(people1Original);
        people1Printer.close();

        Hogwarts h = new Hogwarts();
        h.startCeremony("people.txt");
        System.out.println(h);

        Hogwarts h1 = new Hogwarts();
        h1.startCeremony("people1.txt");
        System.out.println(h1);
    }

}
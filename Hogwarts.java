import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
* Class for the Hogwarts School
*
* @author cproenza3
* @version 1
*/
public class Hogwarts {
    private ArrayList<Wizard> studentList = new ArrayList<Wizard>();

    /**
    * Sorts students into studentList and removes Muggles
    * @param filePath is the file path
    */
    public void sortingHat(String filePath) throws FileNotFoundException,
    ImposterAlertException {
        studentList.clear();
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String scanList = s.nextLine();
            String[] list = scanList.split(",", 0);
            char houseLetter = list[0].charAt(list[0].length() - 1);
            String name = list[0].substring(0, list[0].length() - 1);

            House house;
            switch (houseLetter) {
            case 'G': house = House.GRYFFINDOR; break;
            case 'R': house = House.RAVENCLAW; break;
            case 'S': house = House.SLYTHERIN; break;
            case 'H': house = House.HUFFLEPUFF; break;
            default: throw new ImposterAlertException(scanList);
            }

            int skill = Integer.parseInt(list[1]);
            String patronus = list[2];
            studentList.add(new Wizard(name, house, skill, patronus));
        }
    }

    /**
    * Deletes the line causing an ImposterAlertException
    * @param filePath is the file path
    */
    public void startCeremony(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        String answer = "";
        try {
            this.sortingHat(filePath);
        } catch (ImposterAlertException imp) {
            while (s.hasNextLine()) {
                String str = s.nextLine();
                if (str.equals(imp.getMessage())) {
                    answer += "";
                } else {
                    answer += str + "%n";
                }
            }
            PrintWriter output = new PrintWriter(f);
            output.printf(answer);
            output.close();
            s.close();
            startCeremony(filePath);
        }
    }

    @Override
    public String toString() {
        return "Welcome to Hogwarts! Meet our students: "
            + studentList.toString();
    }
}
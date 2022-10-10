import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test3Prep<T extends Comparable<? super T>,
                        C extends Collection<T>> {

    C c;
    T min = null;
    public int findMin() {
        for (T t : c) {
            if (min == null || t.compareTo(min)) {
                min = t;
            }
            return min;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(args[0]);
        Scanner s = new Scanner(f);
        String a = "";
        while (s.hasNextLine()) {
            a = s.nextLine();
            a += a.toLowerCase();
            a += String.format("%n");
        }
        s.close();
        PrintWriter p = new PrintWriter(f);
        p.print(a);
        p.flush();
        p.close();
    }
}
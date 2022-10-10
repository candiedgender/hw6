import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClosedIOException extends IOException {

    public ClosedIOException() {}

    public ClosedIOException(String message) {
        super(message);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(args[0]);
        Scanner s = new Scanner(f);
        String file = "";
        while (s.hasNextLine()) {
            file += (s.nextLine()).toLowerCase();
            file += String.format("%n");
        }
        s.close();
        PrintWriter pw = new PrintWriter(f);
        pw.print(file);
        pw.flush();
        pw.close();
    }


}
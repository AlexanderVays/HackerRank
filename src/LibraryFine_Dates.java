import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LibraryFine_Dates {

    // Complete the libraryFine function below.
	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
		LocalDate returnDate = LocalDate.of(y1, m1, d1);
        LocalDate dueDate = LocalDate.of(y2, m2, d2);
        int result = returnDate.compareTo(dueDate);
        int fine = 0;
        if(result <= 0) {
            return fine;
        } else if (result > 0){
            if(y1 > y2) {
                fine = 10000;
            } else if(m1 == m2 && y1 == y2) {
                fine = 15*(d1-d2);
            } else if(m1 > m2 && y1 == y2) {
                fine = 500* (m1-m2);
            }
        }
        
        return fine; 
        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
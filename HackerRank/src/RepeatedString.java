import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long count = 0;
        int length = s.length();
        double repeat = (double)n/(double)length;
        long repeatLong = Double.valueOf(Math.floor(repeat)).longValue();
        
        for(int i=0; i<length; i++) {
            if(s.charAt(i) == 'a') {
                count++;
            }
        }
        
        int remain = Long.valueOf(n).intValue() - length*Long.valueOf(repeatLong).intValue();
        long countRemain = 0;
            
        for(int j=0; j<remain; j++) {
            if(s.charAt(j) == 'a') {
                countRemain++;
            }
        }
        
        count = count*repeatLong + countRemain;
               
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

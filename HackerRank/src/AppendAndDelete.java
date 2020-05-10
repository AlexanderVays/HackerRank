import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
	/* You have a string of lowercase English alphabetic letters. You can perform two types of operations on the string:
		1. Append a lowercase English alphabetic letter to the end of the string.
		2. Delete the last character in the string. Performing this operation on an empty string results in an empty string.
		Given an integer k, and two strings, s and t, determine whether or not you can convert  to  by performing exactly  of the above operations on . 
		If it's possible, print Yes. Otherwise, print No. Example: given string s = hackerhappy, neede string = hackerrank, num of operations k = 9. Answer is: Yes */
    static String appendAndDelete(String s, String t, int k) {
        int count = 0;
        for(int i=0; i<java.lang.Math.min(s.length(),t.length()); i++) {
            if(s.charAt(i) == t.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        
        int result = s.length() + t.length()-(2*count);
        System.out.println(result);
        if(result > k) {           
            return "No";
        } else if((s.length()+t.length()-k) < 0){
            return "Yes";
        } else if(result%2 == k%2){
            return "Yes";
        } else {      
            return "No"; 
        }
   }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


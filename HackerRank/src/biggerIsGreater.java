import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class biggerIsGreater {

    // Complete the biggerIsGreater function below.
	/* Lexicographical order is often known as alphabetical order when dealing with strings. 
	 * A string is greater than another string if it comes later in a lexicographically sorted list.
	 * Given a word, create a new word by swapping some or all of its characters. 
	 * This new word must meet two criteria:
		1. It must be greater than the original word
		2. It must be the smallest word that meets the first condition
		For example, given the word [abcd], the next largest word is [abdc].
		Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return "no answer".
		*/
    static String biggerIsGreater(String w) {
    	StringBuilder str = new StringBuilder(w);
    	int i = str.length()-1;
    	while(i>0 && str.charAt(i-1) >= str.charAt(i)) {
    		i--;
    	}
    	if(i <= 0) {
    		return "no answer";
    	}
    	
    	int j = str.length()-1;
    	while(str.charAt(j)<=str.charAt(i-1)) {
    		j--;
    	}
    	
    	char tmp = str.charAt(i-1);
    	str.replace(i-1, i, String.valueOf(str.charAt(j)));
    	str.replace(j, j+1, String.valueOf(tmp));
    	
    	j = str.length()-1;
    	
    	while(i<j) {
    		char temp = str.charAt(i);
        	str.replace(i, i+1, String.valueOf(str.charAt(j)));
        	str.replace(j, j+1, String.valueOf(temp));
        	i++;
        	j--;
    	} 
    	
    	return str.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
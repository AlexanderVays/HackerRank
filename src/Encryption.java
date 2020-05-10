
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
	/* An English text needs to be encrypted using the following encryption scheme.
		First, the spaces are removed from the text. Let L be the length of this text.
		Then, characters are written into a grid, whose rows and columns have the following constraints:
		For example, the sentence: s=if man was meant to stay on the ground god would have gives us roots.
		After removing spaces is 54 characters long. squareOf54 is between 7 and 8, so it is written in the form of a grid with 7 rows and 8 columns.
		ifmanwas  
		meanttos          
		tayonthe  
		groundgo  
		dwouldha  
		vegivenu  
		sroots  
		Ensure that rowsxcolumns>=L
		If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. rowsxcolumns.
		The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. 
		For example, the encoded message for the above rectangle is:
		imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
		You will be given a message to encode and print.
		*/
    static String encryption(String s) {
    	int length = s.length();
        double root = Math.sqrt(Double.valueOf(length));
        int min = (int) Math.floor(root);
        int max = (int) Math.ceil(root);
        String newString = "";

        for(int i=0; i<max; i++) {
            for(int j=i; j<length; j+=max) {
                if(s.charAt(j) != ' ') {
                    newString += s.charAt(j);
                }
            }
            newString += " ";
        }
        return newString;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

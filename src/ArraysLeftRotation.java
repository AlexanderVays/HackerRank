import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArraysLeftRotation {

    // Complete the rotLeft function below.
	/* A left rotation operation on an array shifts each of the array's elements 1 unit to the left. For example, 
	 * if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].
	 */
    static int[] rotLeft(int[] a, int d) {
    	int length = a.length;
    	int output[] = new int[length];
    	int j = d;
    	for(int i=0;i<length-d;i++) {
    		output[i] = a[j];
    		j++;
    	}
    	
    	j = 0;
    	for(int i=length-d; i<length; i++) {
    		output[i] = a[j];
    		j++;
    	}
    	
    	return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

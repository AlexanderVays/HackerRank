import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.Map;

public class Bonetrousle {

    /*
     * Complete the bonetrousle function below.
     */
    static long[] bonetrousle(long n, long k, int b) {
    	 long output[] = new long[b];
    	 BigInteger minValue = new BigInteger(String.valueOf(b*(b+1)/2));
    	 BigInteger maxValue = new BigInteger(String.valueOf(k*(k+1)/2 - (k-b)*(k-b+1)/2));
    	 if(n<minValue.longValue() || n>maxValue.longValue()) {
    		 return new long[] {-1};
    	 }
    	 
    	 BigInteger increment = new BigInteger(String.valueOf((n-minValue.longValue())/b));
    	 BigInteger reminder = new BigInteger(String.valueOf((n-minValue.longValue())%b));  
    	 
    	 for(int i=0; i<b; i++) {
    		 output[i] = (i+1+increment.longValue());
    	 }
    	 
    	 if (reminder.longValue() > 0) {
             output[b-1-(reminder.intValue()-1)] += reminder.longValue();
         } 
    	 
    	 if(reminder.longValue() > 0) {
    		 for(int j=0; j<reminder.longValue(); j++) {
    			 	output[j]++;
    		 } 
    	 } 
             
         return output;  
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nkb = scanner.nextLine().split(" ");

            long n = Long.parseLong(nkb[0].trim());

            long k = Long.parseLong(nkb[1].trim());

            int b = Integer.parseInt(nkb[2].trim());

            long[] result = bonetrousle(n, k, b);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
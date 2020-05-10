import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class theTimeInWords {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
    	String str = "";
    	HashMap<Integer, String> myMapNum = new HashMap<>();
    	myMapNum.put(1, "one");
    	myMapNum.put(2, "two");
    	myMapNum.put(3, "three");
    	myMapNum.put(4, "four");
    	myMapNum.put(5, "five");
    	myMapNum.put(6, "six");
    	myMapNum.put(7, "seven");
    	myMapNum.put(8, "eight");
    	myMapNum.put(9, "nine");
    	myMapNum.put(10, "ten");
    	myMapNum.put(11, "eleven");
    	myMapNum.put(12, "twelve");
    	myMapNum.put(13, "thirteen");
    	myMapNum.put(14, "fourteen");
    	myMapNum.put(15, "quarter");
    	myMapNum.put(16, "sixteen");
    	myMapNum.put(17, "seventeen");
    	myMapNum.put(18, "eighteen");
    	myMapNum.put(19, "nineteen");
    	myMapNum.put(20, "twenty");
    	myMapNum.put(30, "half");
       	
    	if(m==0) { //at hour
    		str = myMapNum.get(h) + " o' clock";
    	} else if (m==15 || m==30) { //quarter or half past hour
    		str = myMapNum.get(m) + " past " + myMapNum.get(h);
    	} else if (m == 45) { //quarter to hour 
    		str = myMapNum.get(60-m) + " to " + (h<12? myMapNum.get(h+1) : myMapNum.get(1));
    	} else if (m<30) {
    		if(m<=20) {
    			str = myMapNum.get(m) + " minute" + (m==1? "" : "s") + " past " + myMapNum.get(h);
    		} else if (m>20) {
    		str = "twenty " + myMapNum.get(m%20) + " minutes past " + myMapNum.get(h);
    		}
    	} else if (m>30) {
    		if(60-m > 20) {
    			str = "twenty " + myMapNum.get((60-m)%20) + " to " + (h<12? myMapNum.get(h+1) : myMapNum.get(1));
    		} else if (60-m <= 20) {
    			str = myMapNum.get(60-m) + " minute" + (m==59? "" : "s") + " to " + (h<12? myMapNum.get(h+1) : myMapNum.get(1));
    		}
    	}
    	
    	return str;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

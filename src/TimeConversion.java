import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
    	DateFormat df12 = new SimpleDateFormat("hh:mm:ssaa"); //12 hours format (aa==PM/AM)
    	DateFormat df24 = new SimpleDateFormat("HH:mm:ss"); //24 hours format
    	Date date = null;
    	String output = null;
    	 try {
			date = df12.parse(s);
			output = df24.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return output;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
    
    
    /* public static void main(String[] args)
    {
       String input = "23/12/2014 10:22:12 PM";
       //Format of the date defined in the input String
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
       //Desired format: 24 hour format: Change the pattern as per the need
       DateFormat outputformat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
       Date date = null;
       String output = null;
       try{
          //Converting the input String to Date
     	 date= df.parse(input);
          //Changing the format of date and storing it in String
     	 output = outputformat.format(date);
          //Displaying the date
     	 System.out.println(output);
       }catch(ParseException pe){
          pe.printStackTrace();
        }
    } */
}

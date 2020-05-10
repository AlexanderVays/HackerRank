import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FlatlandSpaceStation {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
    	ArrayList<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<c.length; i++) {
            myList.add(c[i]);
        }
        
        Collections.sort(myList);
        double max = Math.max(myList.get(0), (n-1)-myList.get(myList.size()-1)); 
        
        for(int i=1; i<myList.size(); i++) {
            double temp = Math.floor((myList.get(i)-myList.get(i-1))/2);
            max = Math.max(max, temp);
        }
        
        return Double.valueOf(max).intValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
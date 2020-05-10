import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Map.Entry;

public class EqualizeTheArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
       int count = 0;
        HashMap<Integer, Integer> myMap = new HashMap<Integer,Integer>();
        for(int i=0; i<arr.length; i++) {
            if(!myMap.containsKey(arr[i])) {
                myMap.put(arr[i], 1);
            } else {
                int temp = myMap.get(arr[i])+1;
                myMap.put(arr[i], temp);
            }
        }
        
        Iterator<Integer> itr = myMap.keySet().iterator();
        while(itr.hasNext()) {
            int key = itr.next();
            if(myMap.get(key) > count) {
                count = myMap.get(key);
            }
        }
        
        return arr.length - count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
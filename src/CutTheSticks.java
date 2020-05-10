import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    	Arrays.sort(arr);   	
    	List<Integer> myList = new ArrayList<Integer>();
    	myList.add(arr.length);
    	
    	for(int i=1; i<arr.length; i++) {
    		if(arr[i] != arr[i-1]) {
    			myList.add(arr.length-i);
    		}
    	}
    	
    	
    	int output[] = new int[myList.size()];
    	
    	for(int i=0; i<myList.size(); i++) {
    		output[i] = myList.get(i);
    	}
    	return output;
    }
    
    static int migratoryBirds(List<Integer> arr) { //return the lowest type number of the most frequently sighted bird.
    	HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
    	for(int i=0; i<arr.size(); i++) {
    		if(!myMap.containsKey(arr.get(i))) {
    			myMap.put(arr.get(i), 1);
    		} else {
    			int temp = myMap.get(arr.get(i)) + 1;
    			myMap.put(arr.get(i), temp);
    		}
    	}
    	
    	int max1 = 0;
    	int key1 = 0;
    	int max2 = 0;
    	int key2 = 0;
    	Iterator<Integer> itr = myMap.keySet().iterator();
    	while(itr.hasNext()) {
    		int key = itr.next();
    		if(myMap.get(key) > max1) {
    			max1 = myMap.get(key);
    			key1 = key;
    		} else if(myMap.get(key) == max1) {
    			max2 = myMap.get(key);
    			key2 = key;
    		}
    	}
    	
    	if(max1 == max2) {
    		if(key1 < key2) {
    			return key1;
    		} else {
    			return key2;
    		}
    	}
    	
    	return key1;
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

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
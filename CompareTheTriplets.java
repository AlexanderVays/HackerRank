import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	List<Integer> myList = new ArrayList<>(2);
    	int counter[] = {0, 0};    	
    	for(int i=0; i<a.size(); i++) {
    		if(a.get(i) != null && a.get(i)<=100 && a.get(i)>=1 && b.get(i) != null && b.get(i)<=100 && b.get(i)>=1) {
    			if(a.get(i) > b.get(i)) {
    				counter[0]++;
    			}
    			if(a.get(i) < b.get(i)) {
    				counter[1]++;
    			}
    		}
    	}

    	for(int j=0; j<counter.length; j++){
    		myList.add(counter[j]);
    	}
    	
    	return myList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

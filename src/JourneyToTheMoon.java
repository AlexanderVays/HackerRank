import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JourneyToTheMoon {

    // Complete the journeyToMoon function below.
    static int journeyToMoon(int n, int[][] astronaut) {
    	int length = astronaut.length;
    	int index = 1;
    	int myArray[][] = new int[index][];
    	//List<List<Integer>> myList = new ArrayList<List<Integer>>();
    	for(int i=0; i<length; i++) {
    		int y=0;
    		for(int j=0; j<length; j++) {
    			if(astronaut[i][0] == astronaut[j][0] || astronaut[i][0] == astronaut[j][1] || astronaut[i][1] == astronaut[j][0] || astronaut[i][1] == astronaut[j][1]) {
    				myArray[index][y] = astronaut[i][0];
    				y++;
    				myArray[index][y] = astronaut[i][1];
    				y++;
    				myArray[index][y] = astronaut[j][0];
    				y++;
    				myArray[index][y] = astronaut[j][1];
    			}
    		}
    		index++;
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        int result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
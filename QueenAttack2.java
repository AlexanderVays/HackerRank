import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueenAttack2 {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	int x = c_q;
    	int y = r_q;
        // horizontally and vertically
        int hr = n-x; //horizontally right
        int hl = x-1; //horizontally left
        int vu = n-y; //vertically up
        int vd = y-1; //vertically down
        
        //diagonally
        int dru = Math.min(n-x, n-y); //diagonally right up
        int drd = Math.min(n-x, y-1); // diagonally right down
        int dlu = Math.min(x-1, n-y); // diagonally left up
        int dld = Math.min(x-1, y-1); // diagonally left down
        
        
        for(int i=0; i<k; i++) {
        	int temp_x = obstacles[i][1];
        	int temp_y = obstacles[i][0];
            if(x < temp_x && y == temp_y)  { //obstacle horizontally right 
                hr = Math.min(hr, temp_x-x-1);
            } 
            
            if(x > temp_x && y == temp_y)  { //obstacle horizontally left 
                hl = Math.min(hl, x-temp_x-1);
            }
            
            if(x == temp_x && y < temp_y)  { //obstacle vertically up 
                vu = Math.min(vu, temp_y-y-1);
            }
            
            if(x == temp_x && y > temp_y)  { //obstacle vertically down 
                vd = Math.min(vd, y-temp_y-1);
            }
            
            if((x < temp_x && y < temp_y) && temp_x-x == temp_y-y) { //obstacle diagonally right up
                dru = Math.min(dru, temp_y-y-1);
            }
            
            if((x < temp_x && y > temp_y) && temp_x-x == y-temp_y) { //obstacle diagonally right down
                drd = Math.min(drd, y-temp_y-1);
            }
            
            if((x > temp_x && y < temp_y) && x-temp_x == temp_y-y) { //obstacle diagonally left up
                dlu = Math.min(dlu, x-temp_x-1);
            }
            
            if((x > temp_x && y > temp_y) && x-temp_x == y-temp_y) { //obstacle diagonally left down
                dld = Math.min(dld, y-temp_y-1);
            }
        }
        
        return hr+hl+vu+vd+dru+drd+dlu+dld;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

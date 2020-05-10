import java.io.*;
import java.math.*;
import java.util.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	int length = arr.length;
        int positives = 0;
        int negatives = 0;
        int zeroes = 0;
        for(int i=0; i<length; i++) {
            if(arr[i] > 0) {
                positives++;
            } else if(arr[i] < 0) {
                negatives++;
            } else {
                zeroes++;
            }
        }
        
    System.out.printf("%.6f\n",(double)positives/length);
    System.out.printf("%.6f\n",(double)negatives/length);
    System.out.printf("%.6f\n",(double)zeroes/length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

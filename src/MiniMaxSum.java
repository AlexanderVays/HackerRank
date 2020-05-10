import java.util.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	long minNum = arr[0];
    	long maxNum = arr[0];
    	long total = 0;
    	for(int i=0; i<arr.length; i++) {
    		total += arr[i];
    		if(arr[i] > maxNum) {
    			maxNum = arr[i];
    		} else if(arr[i] < minNum){
    			minNum = arr[i];
    		}
    	}
 
    	System.out.printf("%d %d", total-maxNum, total-minNum);
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}



public class CakeCandles {
	
	 static int birthdayCakeCandles(int[] ar) {
	       int n = ar.length;
	       int maxNum = 0;
	       int count = 0;
	       for(int i=0; i<n; i++) {
	            if(ar[i] > maxNum) {
	               maxNum = ar[i];
	               count = 1;
	            } else if(ar[i] == maxNum) {
	               count++;
	            }
	       } 
	       return count;
	 }
}

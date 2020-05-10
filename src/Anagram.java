import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Anagram {
	
	static boolean isAnagram(String a, String b) {
    	int lengthA = a.length();
    	int lengthB = b.length();
    	if(lengthA != lengthB) {
    		return false;
    	}
    	
        HashMap<Character, Integer> myMap1 = new HashMap<>();
        HashMap<Character, Integer> myMap2 = new HashMap<>();
        for(int i=0; i<lengthA; i++) {
        	if(!myMap1.containsKey(a.charAt(i))) {
        		myMap1.put(a.charAt(i), 1);
        	} else {
        		int temp = myMap1.get(a.charAt(i))+1;
        		myMap1.put(a.charAt(i), temp);
        	}
        }
        
        for(int i=0; i<lengthB; i++) {
        	if(!myMap2.containsKey(b.charAt(i))) {
        		myMap2.put(b.charAt(i), 1);
        	} else {
        		int temp = myMap2.get(b.charAt(i))+1;
        		myMap2.put(b.charAt(i), temp);
        	}
        }
        
        Iterator<Character> iterator = myMap1.keySet().iterator();
        while(iterator.hasNext()) {
        	char key = iterator.next();
        		if(myMap1.get(key) != myMap2.get(key)) {
        			return false;
        		}
        }
        
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

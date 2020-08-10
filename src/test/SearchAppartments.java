package test;

import java.util.Arrays;

public class SearchAppartments {

	static int[] solve(int size_of_magor, int[] elements_of_magor){
	       // Write your code here
	       boolean merged[] = new boolean[size_of_magor];
	       int mergedCount = 0;
	    
	       for(int i = 1; i < size_of_magor; i++) {
	           if(elements_of_magor[i] >= 0 && elements_of_magor[i - 1] >= 0) {
	               elements_of_magor[i] = elements_of_magor[i] + elements_of_magor[i - 1];
	               mergedCount++;
	               merged[i - 1] = true;
	               elements_of_magor[i - 1] = 0;
	           }

	           else if(elements_of_magor[i] < 0 && elements_of_magor[i - 1] < 0) {
	               elements_of_magor[i] = elements_of_magor[i] + elements_of_magor[i - 1];
	               mergedCount++;
	               merged[i - 1] = true;
	               elements_of_magor[i - 1] = 0;
	           }
	       }

	       int[] mergedArray = new int[size_of_magor - mergedCount];
	       for(int i = 0, j =0; i < elements_of_magor.length; i++) {
	           if(!merged[i]) {
	               mergedArray[j++] = elements_of_magor[i];
	           }
	       }

	       int max = 0;
	       for(int i = 0; i < mergedArray.length; i++) {
	           int sum = mergedArray[i];

	           if(i - 2 >= 0) {
	               sum = sum + mergedArray[i - 2];
	           }
	        
	           if(i + 2 < mergedArray.length) {
	               sum = sum + mergedArray[i + 2];
	           }

	           sum = Math.abs(sum);
	           max = Math.max(max, sum);
	       }

	       int[] result = {mergedArray.length, max};
	       return result;
	}
	
	
	public static void main(String[] args) {
		int[] array = {1, 1, -3, 2, -4, 3};
		int[] result = solve(6, array);
		System.out.println(Arrays.toString(result));
	}
}

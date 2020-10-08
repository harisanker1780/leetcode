package hackerearth;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Solution using Radix sort 
 *
 */
public class MonkAndSortingAlgorithm2 {

	public static void main(String[] args) throws Exception {
		String[] array = {"213456789", "167890", "123456789", "99", "11"};
		sort(array);
	}
	
	private static void sort(String[] array) throws Exception {
		int max = 0;
		for(String s : array) {
			if(s.length() > max) {
				max = s.length();
			}
		}
		
		OutputStream out = new BufferedOutputStream ( System.out );
		
		int start = 0;
		for(int i = 0; i < max; i++) {
			start = countSort(array, array.length, i, start);
			if(i == (max - 1) || (i + 1) % 5 == 0) {
				printResult(array, out);
			}
		}
		
		out.flush();
	}
	
	
	private static void printResult(String[] array, OutputStream out) throws Exception {
		for(String s : array) {
			out.write((s + " ").getBytes());
		}
		
		out.write("\n".getBytes());
	}
	
	private static int countSort(String arr[], int n, int index, int start) 
    { 
        String output[] = new String[n - start]; // output array 
        int i; 
        int count[] = new int[10]; 
        int newStart = start;
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = start; i < n; i++) {
        	if(arr[i].length() <= index) {
        		newStart++;
        	}
        	count[getValueAtIndex(arr[i], index)]++; 
        }
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= start; i--) 
        { 
            output[count[ getValueAtIndex(arr[i], index)] - 1] = arr[i]; 
            count[getValueAtIndex(arr[i], index)]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = start; i < n; i++) 
            arr[i] = output[i - start];
        
        return newStart;
    } 
	
	private static int getValueAtIndex(String s, int index) {
		int indexFromRight = s.length() - index - 1;
		if(indexFromRight >= 0) {
			char c = s.charAt(indexFromRight);
			return c - '0';
		}
		
		return 0;
	}
}

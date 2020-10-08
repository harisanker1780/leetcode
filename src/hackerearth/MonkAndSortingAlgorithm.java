package hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Monk recently taught Fredo about sorting. Now, he wants to check whether he understood the concept or not. So, he gave him the following algorithm and asked to implement it:

Assumptions:
We consider the rightmost digit of each number to be at index 1, second last at index 2 and so on till the leftmost digit of the number.
Meaning of  chunk: This chunk consists of digits from position  to  in the given number.If there is no digit at some position in the number, take the digit to be 0.

Initially, i is 1.

Construct the  chunk, for all of the integers in the array. Let's call the value of this chunk to be the weight of respective integer in the array.
If weight of all the integers of the array is 0, then STOP
Sort the array according to the weights of integers. If two integers have same weight, then the one which appeared earlier should be positioned earlier after the sorting is done. The array changes to this sorted array.
Increment i by 1 and repeat from STEP 1
See the sample explanation for a better understanding.
So, Fredo understood the concept and coded it. Now, Monk asks you to write the code for the algorithm to verify Fredo's answer.

Input:
The first line of the input contains N denoting the number of elements in the array to be sorted.
The next line contains N single space separated integers denoting the array elements.

Output:
You need to print the new array in each step of the algorithm.

Constraints:
; A[] is the input array
Size of integers (number of digits in integer) in A may not be same.
Note

Use Fast I/O
Sample Input
3
213456789 167890 123456789
Sample Output
213456789 123456789 167890 
167890 123456789 213456789 
Explanation
Each line of output is the array after each transformation.
Here goes the explanation:
1st chunk of respective integers= 56789, 67890, 56789
weight of respective integers= 56789, 67890, 56789
So, sorted array according to weights is [213456789, 123456789, 167890] because 56789< 67890.
Note that the weight of 213456789 and 123456789 are the same, so we need to keep the given order.This becomes the new array.

The array now is [213456789, 123456789, 167890]
2nd chunk of respective integers in the array= 02134, 01234, 00001
weight of respective integers= 2134, 1234, 1
So, sorted array according to weights is [167890, 123456789, 213456789] because 1<1234<2134.
This becomes the new array.

The array now is [167890, 123456789, 213456789].
So, as the 3rd chunk would have no digits for any integer, so weights of all integers will be 0 and the algorithm would stop.
 *
 */
public class MonkAndSortingAlgorithm {

	public static void main(String args[] ) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Integer N = Integer.parseInt(br.readLine()); 
//		String[] array = br.readLine().split(" ");
		//String[] array = {"213456789", "167890", "123456789", "11", "99", "9999999999999"};
		String[] array = {"213456789", "167890", "123456789", "99"};
		sort(array);
		
    }
	
	private static void sort(String[] array) throws Exception {
		
		int itrRequired = 0;
		int MAX_LEN = 0;
		
		for(String s : array) {
			if(s.length() > MAX_LEN) {
				MAX_LEN = s.length();
			}
		}
		
		itrRequired = MAX_LEN / 5;
		itrRequired = (MAX_LEN % 5) > 0 ? itrRequired + 1 : itrRequired;
		
		OutputStream out = new BufferedOutputStream ( System.out );
		
		for(int i = 0; i < itrRequired; i++) {
			List<Integer>[] result = new ArrayList[100000];
			String[] copy = new String[array.length];
			for(int j = 0; j < array.length; j++) {
				String s = array[j];
				int num = getNumber(s, (s.length() - 5 * i) - 1);
				
				if(result[num] == null) {
					result[num] = new ArrayList<Integer>();
				}
				
				result[num].add(j);
			}
			
			int count = 0;	
			for(int j = 0; j <= 99999; j++) {
				if(result[j] != null) {
					for(Integer index : result[j]) {
						copy[count] = array[index];
						count++;
					}
				}
				
				if(count == copy.length) {
					break;
				}
			}
			
			for(int k = 0; k < copy.length; k++) {
				String s = copy[k];
				array[k] = s;
				out.write((s + " ").getBytes());
			}
			
			out.write("\n".getBytes());
		}
		
		out.flush();
	}
	
	private static int getNumber(String s, int end) {
		int val = 0;
		if(end >= 0) {
			int base = 1;
			while(base <= 10000 && end >= 0) {
				val += base * (int)(s.charAt(end) - '0');
				base = base * 10;
				end--;
			}
		}
		
		return val;
	}
}

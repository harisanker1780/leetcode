package hackerearth;

import java.util.Arrays;

/**
 * 
 * Given an array  of  integers. Find out the minimum value of the following expression for all valid .

, where .

Input format

First line: A single integer  denoting the number of test cases
For each test case:
First line contains a single integer , denoting the size of the array.
Second line contains  space separated integers 
Output format

For each test case, print a single line containing one integer that represents the minimum value of the given expression

Constraints


Note: Sum of  overall test cases does not exceed 

Sample Input
2
5
1 2 3 4 5
3
2 4 7

Sample Output
1
3

Explanation
For test case #1, we can select elements  and , the value of the expression is , which is the minimum possible value. Another possible pair is 4 and 5.

For test case #2, we can select elements 4 and 7, the value of the expression is , which is the minimum possible value.
 *
 */
public class MininmumAndXorOr {
	
	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 5};
		System.out.println(minimum(array));
	}

	private static int minimum(int[] array) {
		
		Arrays.sort(array);
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < array.length; i++) {
			int a = array[i - 1];
			int b = array[i];
			int result = (a & b) ^ (a | b);
			if(result < min) {
				min = result;
			}
		}
		
		return min;
	}
}

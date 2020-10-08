package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Jehta a famous INTER-NIT player at delhi meets a girl and proposes her but she if so fond of mathematics that she doesn't wanna break with her BF as he is a top notch mathematician (We can not disclose). So to have better mathematician as her BF she challenges manish aka jetha and was given an array A of n elements 

Let us define a function 

Here & represents BIT WISE AND operator.

He needs to find the number of different values of  x  for which  is maximized.

But there is a constraint for x that it must have exactly l bits-set in its binary representation.

Being a good mathematician(Self-Declared) he calculated the answer just to verify wants you to do as well.

Vacancies are still open as she found that both had back-logs in the semester exams(Problem setter has good chances :) ).

Your task is to find number of such values for which this function is maximised.

Print the required number.

If there are infinite  such numbers output -1.

It can be proved that under the given constrainsts the value to be printed is either infinite or not greater than 1e18.

Input:

First line will contain number of test cases T.

Second line of input will contain two space seprated integers n and l (As described in the problem).

Third and final line of input contains n space seprated integers .

Output:

There will be T lines of output:

The only line of output for each test case  contains a single integer as described in problem.

Constraints:





As promised he is a good mathematician but no one wants too much burden so it is guaranteed that sum of  over all test cases will not exceed 2e5.

Sample Input
2
5 2 
3 5 7 1 4
5 1
3 5 7 1 4
Sample Output
2
1
Explanation
For the first test case both 5 and 6 can serve the purpose while in second test case only 4 satisfies the constraints.
 *
 */
public class MaxNum {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	    Integer T = Integer.parseInt(br.readLine());
//	    for(int t = 0; t < T; t++) {
//	    	String[] line = br.readLine().split(" ");
//	    	Integer N = Integer.parseInt(line[0]);
//	    	Integer L = Integer.parseInt(line[1]);
//	    	
//	    	String[] array = br.readLine().split(" ");
//	    	int[] nums = new int[N];
//	    	for(int i = 0; i < N; i++) {
//	    		nums[i] = Integer.parseInt(array[i]);
//	    	}
//	    	
//	    	System.out.println(findMaxNum(nums, L));
//	    }
		
		int[] nums = {3, 5, 9, 1, 4};
		System.out.println(findMaxNum(nums, 2));
		
//		System.out.println(maxSetDigitIndex(7));
	}
	
	private static int findMaxNum(int[] nums, int setBitCount) {
		int max = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		
		int numOfDigitis = maxSetDigitIndex(max);
		
		if(setBitCount > numOfDigitis) {
			return -1;
		}
		
		List<Integer> setBitNums = getNumbersWithBitSet(numOfDigitis, setBitCount);
		
		int maxCount = 0;
		int maxSum = Integer.MIN_VALUE;
		for(Integer setBitNum : setBitNums) {
			int sum = sum(nums, setBitNum);
			if(sum == maxSum) {
				maxCount++;
			} else if(sum > maxSum) {
				maxSum = sum;
				maxCount = 1;
			}
		}
		
		return maxCount;
	}
	
	private static int sum(int[] nums, int x) {
		int sum = 0;
		for(int num : nums) {
			sum += num & x; 
		}
		
		return sum;
	}
	
	private static List<Integer> getNumbersWithBitSet(int numOfDigits, int numOfSetBit) {
		
		char[] array = new char[numOfDigits];
		
		List<Integer> result = new ArrayList<Integer>();
		
		int numOfZero = numOfDigits - numOfSetBit;
		for(int i = 0; i < numOfDigits; i++) {
			if(i < numOfZero) {
				array[i] = '0';
			} else {
				array[i] = '1';
			}
		}
		
		result.add(Integer.parseInt(new String(array), 2));
		
		if(numOfDigits > numOfSetBit) {
			int end = (numOfDigits - numOfSetBit);
			int start = 0;
			while(end < numOfDigits) {
				int  i = end;
				while(i > start) {
					swap(array, i, i - 1);
					result.add(Integer.parseInt(new String(array), 2));
					i--;
				}
				
				start++;
				end++;
			}
		}
		
		return result;
	}
	
	private static int maxSetDigitIndex(int num) {
		return (int)Math.ceil(Math.log(num + 1) / Math.log(2));
	}

	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

package hackerearth;

import java.util.Stack;

public class NumOfPairs {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 2, 1};
		//System.out.println(numOfPairs(nums, 2, 1, 0));
		System.out.println(Integer.MAX_VALUE);
	}
	
	public static long numOfPairs(int[] nums, int K, int X, int Y) {
		
		long[] count = new long[1001];
		for(int num : nums) {
			count[num]++;
		}
		
		long numOfPairs = 0;
		for(int i = X; i <= 1000; i = i + K) {
			int a = (i - 1);
			int b = 1;
			while(a >= b) {
				if(((a * b) % K) == Y) {
					numOfPairs += count[a] * count[b];
				}
				
				a--;
				b++;
			}
		}
		
		return numOfPairs;
	}

}

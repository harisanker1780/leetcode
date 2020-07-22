package test;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 *
 */
public class LongestCommonSubsequence {
	
	
	public int longestCommonSubsequence(String text1, String text2) {
		
		if(text1 == null || text2 == null)
			return 0;
		
		if(text1.length() == 0|| text2.length() == 0)
			return 0;
		
		char[] array1 = text1.toCharArray();
		char[] array2 = text2.toCharArray();
		int s[][] = new int[array1.length][array2.length];
		
		for(int i = 0; i< array1.length; i++) {
			for(int j = 0; j< array2.length; j++) {
				if(array1[i] == array2[j]) {
					if(i > 0 && j > 0)
						s[i][j] = s[i - 1][j - 1] + 1;
					else
						s[i][j] = 1;
				} else {
					int max = 0;
					if(i > 0)
						max = Math.max(max, s[i - 1][j]);
					if(j > 0)
						max = Math.max(max, s[i][j - 1]);
					
					s[i][j] = max; 
				}
			}
		}
		
		return s[array1.length - 1][array2.length - 1];
    }
	
	public static void main(String[] args) {
		LongestCommonSubsequence sol = new LongestCommonSubsequence();
		System.out.println(sol.longestCommonSubsequence("abcde", "ace"));
		System.out.println(sol.longestCommonSubsequence("abc", "abc"));
		System.out.println(sol.longestCommonSubsequence("abc", "def"));
	}
}

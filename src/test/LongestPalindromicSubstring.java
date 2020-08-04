package test;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 *
 */
public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
		
		if(s == null)
			return "";
		
		s = s.trim();
		if(s.length() == 0)
			return "";
		
        char[] str = s.toCharArray();
        int n = str.length;
        int[] count = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
        	for(int j = n - 1; j >= 0; j--) {
        		if(str[i] == str[j]) {
        			int prevCount = j > 0 ? count[j - 1] : 0;
        			count[j] = Math.max(count[j], prevCount + 1);
        		}
        	}
        }
        
        int maxIndex = 0;
        for(int i = 1; i < n; i++) {
        	if(count[i] > count[maxIndex]) {
        		if(isPalindrome(i - (count[i] - 1), i, str)) {
        			maxIndex = i;
        		}
        	}
        }
        
        return s.substring(maxIndex - (count[maxIndex] - 1), maxIndex + 1);
    }
	
	private boolean isPalindrome(int i, int j, char[] str) {
		while(i < j) {
			if(str[i] != str[j])
				return false;
			
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
		
//		  System.out.println(sol.longestPalindrome("babad"));
//		  System.out.println(sol.longestPalindrome("cbbd"));
//		  System.out.println(sol.longestPalindrome("abcd"));
//		  System.out.println(sol.longestPalindrome("aaaa"));
//		  System.out.println(sol.longestPalindrome("abba"));
//		 
//		 
//		  System.out.println(sol.longestPalindrome("abcda"));
//		  System.out.println(sol.longestPalindrome("aaacdaaa"));
		  
		  System.out.println(sol.longestPalindrome("cbcdcbedcbc"));
	}

}

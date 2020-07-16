package test;

/**
 *
 *  Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
 *
 */
public class BackspaceStringCompare {
	
	public boolean backspaceCompare(String S, String T) {
        
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		
		int i = s.length - 1;
		int j = t.length - 1;
		
		while(true) {
			int bsCount = 0;
			while(i >= 0) {
				if(s[i] == '#') {
					i--;
					bsCount++;
				} else if(bsCount > 0) {
					i--;
					bsCount--;
				} else {
					break;
				}
			}
			
			bsCount = 0;
			while(j >= 0) {
				if(t[j] == '#') {
					j--;
					bsCount++;
				} else if(bsCount > 0) {
					j--;
					bsCount--;
				} else {
					break;
				}
			}
			
			if(i < 0 || j < 0) {
				break;
			}
			
			if(s[i] != t[j]) {
				return false;
			}
			
			i--;
			j--;
		}
		
		return i < 0 && j < 0;
    }
	
	public static void main(String[] args) {
		BackspaceStringCompare sol = new BackspaceStringCompare();
		System.out.println(sol.backspaceCompare("ab#c", "ad#c"));
		System.out.println(sol.backspaceCompare("ab##", "c#d#"));
		System.out.println(sol.backspaceCompare("a##c", "#a#c"));
		System.out.println(sol.backspaceCompare("a#c", "b"));
		System.out.println(sol.backspaceCompare("a#c#######", "b#######"));
		System.out.println(sol.backspaceCompare("", ""));
		System.out.println(sol.backspaceCompare("#", "#"));
		System.out.println(sol.backspaceCompare("ab", "ab"));
		System.out.println(sol.backspaceCompare("a", "a"));
		System.out.println(sol.backspaceCompare("ab", "ac"));
		
		System.out.println(sol.backspaceCompare("bxj##tw", "bxo#j##tw"));
	}
}

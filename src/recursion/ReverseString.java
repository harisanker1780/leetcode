package recursion;

/**
 * 
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 * 
 * 
 * 
 * @author haris
 *
 */
public class ReverseString {

	public void reverseString(char[] s) {
		if(s != null)
			reverseString(0, s);
    }
	
	private void reverseString(int index, char[] s) {
		
		if(index >= s.length)
			return;
		
		char c = s[s.length - (index + 1)];
		reverseString(index + 1, s);
		s[index] = c;
	}
	
	public static void main(String[] args) {
		char[] s =null;
		
		ReverseString sol = new ReverseString();
		sol.reverseString(s);
		System.out.println(s);
	}
}

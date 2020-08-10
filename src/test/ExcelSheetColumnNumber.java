package test;

/**
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 

Constraints:

1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".

 *
 */
public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
        
		char[] array = s.toCharArray();
		int pow = 0;
		int number = 0;
		for(int i = array.length - 1; i >= 0; i--) {
			char c = array[i];
			number += Math.pow(26, pow) * ((c - 'A') + 1);
			pow++;
		}
		
		return number;
    }
	
	public static void main(String[] args) {
		ExcelSheetColumnNumber sol = new ExcelSheetColumnNumber();
		System.out.println(sol.titleToNumber("ABC"));
	}
}

package epi.string;

import java.util.Arrays;

public class TelexEncoding {
	
	/**
	 * 
	 * @param c
	 * @param size
	 * @return
	 */
	public static int telexEncode(char[] c, int size) {
		
		int finalSize = 0;
		for(int i = 0; i < size; i++) {
			if(isPunctuationMark(c[i])) {
				finalSize += punctuationMarkWord(c[i]).length;
			}
			else {
				finalSize += 1;
			}
		}
		
		int writeIndex = finalSize - 1;
		for(int i = size - 1; i >= 0; i--) {
			if(isPunctuationMark(c[i])) {
				char[] word = punctuationMarkWord(c[i]);
				for(int j = word.length - 1; j >= 0; j--) {
					c[writeIndex--] = word[j];
				}
			}
			else {
				c[writeIndex--] = c[i];
			}
		}
		
		return finalSize;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static char[] punctuationMarkWord(char c) {
		switch(c) {
			case '.':
				return new char[]{'D', 'O', 'T'};
			case ',':
				return new char[] {'C', 'O', 'M', 'M', 'A'};
			case '?':
				return new char[] {'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N', ' ', 'M', 'A', 'R', 'K'};
			case '!':
				return new char[] {'E', 'X', 'C', 'L', 'A', 'M', 'A', 'T', 'I', 'O', 'N', ' ', 'M', 'A', 'R', 'K'};
		}
		
		return null;
	}
	
	/**
	 *  Return true if the passed character is punctuation mark.
	 * @param c
	 * @return
	 */
	private static boolean isPunctuationMark(char c) {
		return c == '.' || c == ',' || c == '?' || c == '!';
	}
	
	public static void main(String[] args) {
		char[] c = {'A', 'B', '1', '2', '5', ',', 'S', 'N', '7', '.', '?', 'P', '2', 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(telexEncode(c, 13));
		System.out.println(Arrays.toString(c));
	}

}

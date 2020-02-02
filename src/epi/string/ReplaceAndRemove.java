package epi.string;

import java.util.Arrays;

public class ReplaceAndRemove {
	
	public static int replaceAndRemove(int size, char[] s) {
		
		// Remove b
		int nonBIndex = 0;
		for(int i = 0; i < size; i++) {
			if(s[i] != 'b') {
				swap(s, i, nonBIndex++);
			}
		}
		
		// Calculate the final size
		size = nonBIndex;
		int finalSize = 0;
		for(int i = 0; i < size; i++) {
			finalSize = finalSize + (s[i] == 'a' ? 2 : 1);
		}
		
		// Iterate backwards and replace a with 2 d's
		int itr = finalSize - 1;
		for(int i = size - 1; i >= 0; i--) {
			if(s[i] == 'a') {
				s[itr--] = 'd';
				s[itr--] = 'd';
			}
			else { 
				s[itr--] = s[i];
			}
		}
		
		return finalSize;
	}
	
	private static void swap(char[] s, int i , int j) {
		if(i != j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		char[] s = {'a', 'a', 'm', 'n', 'p', 'b', 'b'};
		System.out.println(replaceAndRemove(7, s));
		System.out.println(Arrays.toString(s));
	}

}

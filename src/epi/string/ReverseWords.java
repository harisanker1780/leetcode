package epi.string;

public class ReverseWords {
	
	public static void reverseWords(char[] input) {
		
		reverse(input, 0, input.length - 1);
		
		int start = 0;
		int end = 0;
		while((end = find(input, ' ', start)) != -1) {
			reverse(input, start, end - 1);
			start = end + 1;
		}
		
		reverse(input, start, input.length - 1);
	}
	
	private static void reverse(char[] input, int start, int end) {
		while(start < end) 
			swap(input, start++, end--);
	}
	
	private static int find(char[] input, char c, int start) {
		for(int i = start; i < input.length; i++) {
			if(input[i] == c) {
				return i;
			}
		}
		
		return -1;
	}
	
	private static void swap(char[] input, int i, int j) {
		if(i != j) {
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		String input = " solution ";
		char[] inputArray = input.toCharArray();
		reverseWords(inputArray);
		System.out.println(new String(inputArray));
	}
}
